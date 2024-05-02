/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOAddBlCntrMFOBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.11 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOAddBlCntrMFOBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddBlCntrMF
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOAddBlCntrMFOBCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOAddBlCntrMFOBCSQL").append("\n"); 
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
		query.append("INTO BKG_CSTMS_EUR_IO_CNTR_MF( BND_TP_CD," ).append("\n"); 
		query.append("VSL_CD,     SKD_VOY_NO,       SKD_DIR_CD," ).append("\n"); 
		query.append("BL_NO,      CSTMS_PORT_CD,    CNTR_NO," ).append("\n"); 
		query.append("PCK_QTY,    CNTR_MF_MK_DESC,  CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("PCK_TP_CD,  MEAS_QTY,         MEAS_UT_CD," ).append("\n"); 
		query.append("CMDT_HS_CD, CNTR_MF_WGT,      WGT_UT_CD," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT,           UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("CNTR_CGO_SEQ )" ).append("\n"); 
		query.append("VALUES( 'O'," ).append("\n"); 
		query.append("SUBSTR(@[vvd], 1, 4),      	SUBSTR(@[vvd], 5, 4),                 SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("@[bl_no],      		@[cstms_port_cd],                     @[cntr_no]," ).append("\n"); 
		query.append("@[pck_qty],      	NVL(TRIM(@[cntr_mf_mk_desc]), 'N/M'), @[cntr_mf_gds_desc]," ).append("\n"); 
		query.append("@[pck_tp_cd],      	@[meas_qty],      	                  @[meas_ut_cd]," ).append("\n"); 
		query.append("@[cmdt_hs_cd],      @[cntr_mf_wgt],    	                  @[wgt_ut_cd]," ).append("\n"); 
		query.append("@[cre_usr_id],      sysdate,			                  @[upd_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("(SELECT NVL(MAX(TO_NUMBER(CNTR_CGO_SEQ)), 0) + 1" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_CNTR_MF" ).append("\n"); 
		query.append("WHERE VSL_CD||SKd_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}