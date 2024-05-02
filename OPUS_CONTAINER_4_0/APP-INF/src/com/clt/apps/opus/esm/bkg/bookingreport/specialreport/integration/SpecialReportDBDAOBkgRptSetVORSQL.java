/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialReportDBDAOBkgRptSetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOBkgRptSetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialReportDBDAOBkgRptSetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOBkgRptSetVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.USR_ID" ).append("\n"); 
		query.append(",	A.BKG_RPT_KND_CD" ).append("\n"); 
		query.append(",	A.RPT_ID" ).append("\n"); 
		query.append(",	A.VIS_FLG" ).append("\n"); 
		query.append(",	A.DP_SEQ" ).append("\n"); 
		query.append(",	A.SC_NO" ).append("\n"); 
		query.append(",	A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD" ).append("\n"); 
		query.append(",	A.CUST_SEQ" ).append("\n"); 
		query.append(",	A.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	B.USR_NM" ).append("\n"); 
		query.append(",	B.OFC_CD" ).append("\n"); 
		query.append(",   NVL((SELECT 'Y' FROM BKG_RPT_DFLT D WHERE D.BKG_RPT_KND_CD = A.BKG_RPT_KND_CD AND D.RPT_ID = A.RPT_ID AND D.OWNR_USR_ID = A.USR_ID),'N') AS OWNR_FLG" ).append("\n"); 
		query.append("FROM BKG_RPT_SET A" ).append("\n"); 
		query.append("    ,COM_USER    B" ).append("\n"); 
		query.append("WHERE	A.USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND	A.BKG_RPT_KND_CD = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("AND	A.RPT_ID = @[rpt_id]" ).append("\n"); 
		query.append("#if (${usr_id} != '') " ).append("\n"); 
		query.append("AND	A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}