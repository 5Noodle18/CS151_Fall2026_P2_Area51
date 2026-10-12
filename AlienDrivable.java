public interface AlienDrivable extends Drivable
{
    /* sucks someone up into the UFO */
    void abduct(Personnel abductee);

    /* spits someone who is inside the UFO's holding bay out */
    Personnel unAbduct();

    /* starts the proton drive */
    void startProtonDrive();

}
