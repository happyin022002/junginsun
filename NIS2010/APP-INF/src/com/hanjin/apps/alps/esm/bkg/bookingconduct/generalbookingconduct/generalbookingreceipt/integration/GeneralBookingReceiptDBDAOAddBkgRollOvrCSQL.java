/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgRollOvrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddBkgRollOvrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_ROLL_OVR 정보 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgRollOvrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgRollOvrCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("INSERT INTO BKG_ROLL_OVR (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	ROLL_OVR_SEQ" ).append("\n"); 
		query.append(",	PRE_VSL_CD" ).append("\n"); 
		query.append(",	PRE_SKD_VOY_NO" ).append("\n"); 
		query.append(",	PRE_SKD_DIR_CD" ).append("\n"); 
		query.append(",	PRE_ETD_DT" ).append("\n"); 
		query.append(",	NEW_VSL_CD" ).append("\n"); 
		query.append(",	NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(",	NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", 	NEW_ETD_DT" ).append("\n"); 
		query.append(",	ROLL_OVR_RSN_CD" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	EVNT_USR_ID" ).append("\n"); 
		query.append(",	EVNT_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   PRE_ETA_DT" ).append("\n"); 
		query.append(",   PRE_BKG_POD_ETA_DT " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	bk.bkg_no" ).append("\n"); 
		query.append(",	(NVL((SELECT /*+ INDEX_DESC(ovr XPKBKG_ROLL_OVR)  */" ).append("\n"); 
		query.append("                   ROLL_OVR_SEQ" ).append("\n"); 
		query.append("             FROM  BKG_ROLL_OVR ovr" ).append("\n"); 
		query.append("    		 WHERE ovr.BKG_NO = bk.bkg_no" ).append("\n"); 
		query.append("             AND   ROWNUM = 1), 0) + 1)" ).append("\n"); 
		query.append(",   vvd.vsl_cd" ).append("\n"); 
		query.append(",	vvd.skd_voy_no" ).append("\n"); 
		query.append(",	vvd.skd_dir_cd" ).append("\n"); 
		query.append(",	(SELECT VPS_ETD_DT FROM VSK_VSL_PORT_SKD skd" ).append("\n"); 
		query.append("     WHERE skd.VSL_CD = vvd.vsl_cd AND skd.SKD_VOY_NO = vvd.skd_voy_no AND skd.SKD_DIR_CD = vvd.skd_dir_cd" ).append("\n"); 
		query.append("     AND skd.VPS_PORT_CD = vvd.pol_cd AND skd.CLPT_IND_SEQ = vvd.pol_clpt_ind_seq)" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",   null" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   (SELECT VPS_ETA_DT FROM VSK_VSL_PORT_SKD SKD -- FIRST POL ETA" ).append("\n"); 
		query.append("      WHERE SKD.VSL_CD = VVD.VSL_CD AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND SKD.VPS_PORT_CD = VVD.POL_CD AND SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(",   (SELECT VPS_ETA_DT -- LAST POD ETA" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("          , BKG_VVD          VVDD" ).append("\n"); 
		query.append("      WHERE VVDD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("        AND VVDD.POD_CD = BK.POD_CD" ).append("\n"); 
		query.append("        AND SKD.VSL_CD = VVDD.VSL_CD AND SKD.SKD_VOY_NO = VVDD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVDD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND SKD.VPS_PORT_CD = VVDD.POD_CD AND SKD.CLPT_IND_SEQ = VVDD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND VVDD.VSL_PRE_PST_CD||VVDD.VSL_SEQ = (SELECT MAX(MAX_SEQ.VSL_PRE_PST_CD||MAX_SEQ.VSL_SEQ) " ).append("\n"); 
		query.append("										           FROM BKG_VVD MAX_SEQ " ).append("\n"); 
		query.append("										          WHERE MAX_SEQ.BKG_NO = VVDD.BKG_NO " ).append("\n"); 
		query.append("										            AND MAX_SEQ.POD_CD = VVDD.POD_CD)" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append(" where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("   and vvd.vsl_pre_pst_cd||vvd.vsl_seq = (select min(min_seq.vsl_pre_pst_cd||min_seq.vsl_seq) " ).append("\n"); 
		query.append("										    from bkg_vvd min_seq " ).append("\n"); 
		query.append("										   where min_seq.bkg_no = bk.bkg_no " ).append("\n"); 
		query.append("										     and bk.pol_cd      = vvd.pol_cd)" ).append("\n"); 
		query.append("   and bk.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}