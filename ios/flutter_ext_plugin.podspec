#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint flutter_ext_plugin.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_ext_plugin'
  s.version          = '0.0.1'
  s.summary          = 'A Flutter extension plugin.'
  s.description      = <<-DESC
A Flutter extension plugin.
                       DESC
  s.homepage         = 'https://litslink.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'LITSLINK' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '8.0'

  # Flutter.framework does not contain a i386 slice. Only x86_64 simulators are supported.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'VALID_ARCHS[sdk=iphonesimulator*]' => 'x86_64' }
  s.swift_version = '5.0'
end
