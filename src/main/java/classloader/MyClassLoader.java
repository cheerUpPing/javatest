package classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * 2016/8/26 11:35.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class MyClassLoader extends ClassLoader {


    protected MyClassLoader() {
        super();
    }

    protected MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public void clearAssertionStatus() {
        super.clearAssertionStatus();
    }

    @Override
    protected Package definePackage(String name, String specTitle, String specVersion, String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        return super.definePackage(name, specTitle, specVersion, specVendor, implTitle, implVersion, implVendor, sealBase);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    protected String findLibrary(String libname) {
        return super.findLibrary(libname);
    }

    @Override
    protected URL findResource(String name) {
        return super.findResource(name);
    }

    @Override
    protected Enumeration<URL> findResources(String name) throws IOException {
        return super.findResources(name);
    }

    @Override
    protected Object getClassLoadingLock(String className) {
        return super.getClassLoadingLock(className);
    }

    @Override
    protected Package getPackage(String name) {
        return super.getPackage(name);
    }

    @Override
    protected Package[] getPackages() {
        return super.getPackages();
    }

    @Override
    public URL getResource(String name) {
        return super.getResource(name);
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        return super.getResourceAsStream(name);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return super.getResources(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    public void setClassAssertionStatus(String className, boolean enabled) {
        super.setClassAssertionStatus(className, enabled);
    }

    @Override
    public void setDefaultAssertionStatus(boolean enabled) {
        super.setDefaultAssertionStatus(enabled);
    }

    @Override
    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        super.setPackageAssertionStatus(packageName, enabled);
    }
}
