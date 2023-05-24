def incrementNpmMinorVersion(){
    def old_package_file = readJSON file:'package.json'
    def old_version = "${old_package_file.version}"
    def package_name = "${old_package_file.name}"
    sh "npm version minor"

    def package_file = readJSON file:'package.json'
    def version = "${package_file.version}"
    env.NEW_VERSION = "$version"

    echo "incrementing $package_name from $old_version to $version"
    //define the version var used for the container image
    env.IMAGE_VERSION = "$version-$BUILD_NUMBER"
}