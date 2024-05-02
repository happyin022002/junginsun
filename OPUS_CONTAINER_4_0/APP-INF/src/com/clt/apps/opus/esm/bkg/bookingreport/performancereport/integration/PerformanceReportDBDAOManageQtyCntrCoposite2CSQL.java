/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOManageQtyCntrCoposite2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOManageQtyCntrCoposite2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOManageQtyCntrCoposite2CSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOManageQtyCntrCoposite2CSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOManageQtyCntrCoposite2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DPCS_PROC_SMRY" ).append("\n"); 
		query.append("                (BKG_NO" ).append("\n"); 
		query.append("                ,BKG_DOC_DT" ).append("\n"); 
		query.append("                ,DOC_KND_STS_CD" ).append("\n"); 
		query.append("                ,DOC_PROC_RSLT_TP_CD" ).append("\n"); 
		query.append("                ,SLAN_CD" ).append("\n"); 
		query.append("                ,VSL_CD" ).append("\n"); 
		query.append("                ,SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                ,POL_CD" ).append("\n"); 
		query.append("                ,POD_CD" ).append("\n"); 
		query.append("                ,BKG_OFC_CD" ).append("\n"); 
		query.append("                ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                ,DOC_USR_ID" ).append("\n"); 
		query.append("                ,DPCS_SMRY_RMK" ).append("\n"); 
		query.append("                ,CNTR_TEU_QTY" ).append("\n"); 
		query.append("                ,CNTR_FEU_QTY" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT)" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT        " ).append("\n"); 
		query.append("               BK.BKG_NO V_BKG_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(SYSDATE , 'yyyymmdd')" ).append("\n"); 
		query.append("              ,'8'" ).append("\n"); 
		query.append("              ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("              ,BK.SLAN_CD V_BKG_LANE" ).append("\n"); 
		query.append("              ,BK.VSL_CD V_VSL_CD" ).append("\n"); 
		query.append("              ,BK.SKD_VOY_NO V_VOY_NO" ).append("\n"); 
		query.append("              ,BK.SKD_DIR_CD V_VOY_DIR" ).append("\n"); 
		query.append("              ,BK.POL_CD V_POL_LOC" ).append("\n"); 
		query.append("              ,BK.POD_CD V_POD_LOC" ).append("\n"); 
		query.append("              ,BK.BKG_OFC_CD V_BKG_OFC    " ).append("\n"); 
		query.append("              ,BK.OB_SLS_OFC_CD V_SAL_OFC" ).append("\n"); 
		query.append("              ,BK.DOC_USR_ID V_BKG_STF" ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE - 1, BK.POL_CD), 'yyyymmdd')  V_RMK" ).append("\n"); 
		query.append("    		  ,SUM(decode(substr(B.CNTR_TPSZ_CD,-1),'2',NVL(B.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("              ,SUM(decode(substr(B.CNTR_TPSZ_CD,-1),'2',0,NVL(B.OP_CNTR_QTY,0)))" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("              --,SUM(DECODE(GREATEST(2,SUBSTR(B.CNTR_TPSZ_CD,2,1)),2,NVL(B.OP_CNTR_QTY,0),0)) TEU_A" ).append("\n"); 
		query.append("              --,SUM(DECODE(GREATEST(2,SUBSTR(B.CNTR_TPSZ_CD,2,1)),2,0,NVL(B.OP_CNTR_QTY,0))) TEU_B" ).append("\n"); 
		query.append("              ,'System'" ).append("\n"); 
		query.append("              ,sysdate" ).append("\n"); 
		query.append("              ,'System'" ).append("\n"); 
		query.append("              ,Sysdate" ).append("\n"); 
		query.append("        FROM   BKG_BOOKING  BK" ).append("\n"); 
		query.append("              ,BKG_QUANTITY B" ).append("\n"); 
		query.append("        WHERE  BK.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("        AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          GROUP BY " ).append("\n"); 
		query.append("               BK.BKG_NO " ).append("\n"); 
		query.append("              ,TO_CHAR( SYSDATE, 'yyyymmdd')" ).append("\n"); 
		query.append("              ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("              ,BK.SLAN_CD" ).append("\n"); 
		query.append("              ,BK.VSL_CD " ).append("\n"); 
		query.append("              ,BK.SKD_VOY_NO " ).append("\n"); 
		query.append("              ,BK.SKD_DIR_CD " ).append("\n"); 
		query.append("              ,BK.POL_CD " ).append("\n"); 
		query.append("              ,BK.POD_CD " ).append("\n"); 
		query.append("              ,BK.BKG_OFC_CD " ).append("\n"); 
		query.append("              ,BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("              ,BK.DOC_USR_ID " ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE - 1, BK.POL_CD), 'yyyymmdd') " ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}