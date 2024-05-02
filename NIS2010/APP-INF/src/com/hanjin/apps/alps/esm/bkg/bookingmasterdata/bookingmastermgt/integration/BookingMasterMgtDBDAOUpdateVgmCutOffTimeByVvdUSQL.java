/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingMasterMgtDBDAOUpdateVgmCutOffTimeByVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */
 
public class BookingMasterMgtDBDAOUpdateVgmCutOffTimeByVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VGM CCT Creation 에 입력된 VVD 정보에 따라 VGM CCT를 재 Setting한다
	  * </pre>
	  */
	public BookingMasterMgtDBDAOUpdateVgmCutOffTimeByVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOUpdateVgmCutOffTimeByVvdUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CLZ_TM TM " ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT VVD.BKG_NO" ).append("\n"); 
		query.append("          ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          ,VVD.POL_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(VVD.POL_CLPT_IND_SEQ) POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,BK.POD_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK, BKG_VVD VVD, BKG_BL_DOC DOC, MDM_LOCATION MDM" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("       AND BK.POL_CD = @[yd_cd]" ).append("\n"); 
		query.append("       AND DECODE(@[vsl_slan_cd],'*',VVD.SLAN_CD, @[vsl_slan_cd]) = VVD.SLAN_CD" ).append("\n"); 
		query.append("       AND DECODE(@[dest_cnt_cd],'*',SUBSTR(BK.POD_CD, 1, 2), @[dest_cnt_cd]) = SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("       AND DECODE(@[conti_cd],'*',MDM.CONTI_CD, @[conti_cd]) = MDM.CONTI_CD" ).append("\n"); 
		query.append("       AND BK.POD_CD = MDM.LOC_CD" ).append("\n"); 
		query.append("       AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("       AND DOC.bdr_flg = 'N'" ).append("\n"); 
		query.append(") TGT" ).append("\n"); 
		query.append("ON (TM.BKG_NO = TGT.BKG_NO AND TM.CLZ_TP_CD = 'V')" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append(" TM.SYS_SET_DT = (SELECT BKG_GET_VRFD_WGT_CUT_OFF_FNC(TGT.VVD_CD, TGT.POL_CD, TGT.POL_CLPT_IND_SEQ, TGT.POD_CD) FROM DUAL)" ).append("\n"); 
		query.append(",TM.MNL_SET_DT = TO_DATE(DECODE(TM.MNL_SET_DT,'','',TO_CHAR((SELECT BKG_GET_VRFD_WGT_CUT_OFF_FNC(TGT.VVD_CD, TGT.POL_CD, TGT.POL_CLPT_IND_SEQ, TGT.POD_CD) FROM DUAL),'YYYYMMDDHH24MISS')),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",TM.MNL_SET_USR_ID = DECODE(TM.MNL_SET_USR_ID,'','',@[upd_usr_id])" ).append("\n"); 
		query.append(",TM.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",TM.UPD_DT = SYSDATE" ).append("\n"); 

	}
}