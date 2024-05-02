/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOaddPsaCntrCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.31 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOaddPsaCntrCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_PSA_DG_CGO Insert
	  * </pre>
	  */
	public PSASpecialManifestDBDAOaddPsaCntrCgoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grosswgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imo_clss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrnbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_nbr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOaddPsaCntrCgoCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_CSTMS_PSA_DG_CGO( MSG_SND_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD, CNTR_NO, DCGO_SEQ, IMDG_UN_NO, IMDG_UN_NO_SEQ, GRS_WGT, IMDG_CLSS_CD, PCK_QTY, PCK_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, WGT_UT_CD, MEAS_QTY, MEAS_UT_CD )" ).append("\n"); 
		query.append("VALUES(@[msg_snd_no], " ).append("\n"); 
		query.append("	  SUBSTR(@[vvd_cd], 1, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd_cd], 5, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd_cd], 9, 1)," ).append("\n"); 
		query.append("      @[bl_no]," ).append("\n"); 
		query.append("      'D', --cstms_port_cd" ).append("\n"); 
		query.append("      @[cntrnbr]," ).append("\n"); 
		query.append("      (SELECT NVL(MAX(TO_NUMBER(DCGO_SEQ)), 0) + 1" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_PSA_DG_CGO" ).append("\n"); 
		query.append("        WHERE VSL_CD||SKd_VOY_NO||SKD_DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("          AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          AND CSTMS_PORT_CD = 'D' --cstms_port_cd" ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntrnbr])," ).append("\n"); 
		query.append("      @[un_nbr]," ).append("\n"); 
		query.append("      @[un_nbr_seq]," ).append("\n"); 
		query.append("      @[grosswgt]," ).append("\n"); 
		query.append("      @[imo_clss]," ).append("\n"); 
		query.append("      @[pck_qty]," ).append("\n"); 
		query.append("      ''," ).append("\n"); 
		query.append("      @[usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      ''," ).append("\n"); 
		query.append("      ''," ).append("\n"); 
		query.append("      '' )" ).append("\n"); 

	}
}