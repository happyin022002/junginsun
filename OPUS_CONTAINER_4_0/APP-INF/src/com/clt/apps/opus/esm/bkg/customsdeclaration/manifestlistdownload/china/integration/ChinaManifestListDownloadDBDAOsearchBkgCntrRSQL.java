/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCntr
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchBkgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchBkgCntrRSQL").append("\n"); 
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
		query.append("SELECT  BB.BL_NO					AS BL_NO," ).append("\n"); 
		query.append("        BC.CNTR_NO					AS CNTR_NO," ).append("\n"); 
		query.append("        BC.CNTR_TPSZ_CD				AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    	DECODE(BB.BKG_CGO_TP_CD, 'P', 'E', 'R', 'E', 'F') AS FULL_MTY_CD," ).append("\n"); 
		query.append("    	DECODE(NVL(BC.WGT_UT_CD, ' '),'LBS',ROUND(NVL(BC.CNTR_WGT, 0)*0.4536,3),NVL(BC.CNTR_WGT, 0)) AS CNTR_WGT," ).append("\n"); 
		query.append("    	DECODE(NVL(BC.WGT_UT_CD, ' '),'LBS','KGS',NVL(BC.WGT_UT_CD, ' ')) AS WGT_UT_CD," ).append("\n"); 
		query.append("    	DECODE(NVL(BC.MEAS_UT_CD,' '),'CBF',ROUND(NVL(BC.MEAS_QTY,0)*0.0283,3), NVL(BC.MEAS_QTY,0)) AS CNTR_MEAS_QTY," ).append("\n"); 
		query.append("        DECODE(BC.MEAS_QTY,0,' ','CBM') AS MEAS_UT_CD," ).append("\n"); 
		query.append("    	NVL(BC.PCK_QTY, 0)			AS PCK_QTY," ).append("\n"); 
		query.append("    	BC.PCK_TP_CD				AS PCK_TP_CD," ).append("\n"); 
		query.append("    	@[trans_mode]				AS CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("		@[usr_id]					AS CRE_USR_ID," ).append("\n"); 
		query.append("		@[usr_id]					AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM	BKG_CONTAINER BC," ).append("\n"); 
		query.append("        BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end      BB.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND     DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	    BB.BKG_NO = BC.BKG_NO" ).append("\n"); 

	}
}