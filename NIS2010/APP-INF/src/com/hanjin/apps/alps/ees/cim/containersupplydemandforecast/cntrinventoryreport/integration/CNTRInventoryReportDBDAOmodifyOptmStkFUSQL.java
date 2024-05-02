/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOmodifyOptmStkFUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOmodifyOptmStkFUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016-02-02
	  * Equipment Management > CNTR Inventory > Inventory Status > Land Inventory > Land Inventory with Optimum Stock 수정
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOmodifyOptmStkFUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOmodifyOptmStkFUSQL").append("\n"); 
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
		query.append("MERGE INTO CIM_OPTM_STK_SMRY OPS" ).append("\n"); 
		query.append("USING ( SELECT 'F' OPTM_STK_MNG_TP_CD" ).append("\n"); 
		query.append("              ,'A' DMG_FLG" ).append("\n"); 
		query.append("              ,@[tp_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,@[loc_cd] ECC_CD" ).append("\n"); 
		query.append("              ,@[qty1] CNTR_QTY" ).append("\n"); 
		query.append("              ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("              ,'99991231' TGT_MVMT_DT" ).append("\n"); 
		query.append("              ,'XX' MVMT_STS_CD" ).append("\n"); 
		query.append("              ,'' TGT_BSE_DT" ).append("\n"); 
		query.append("              ,(SELECT MAX(TGT_YRWK) " ).append("\n"); 
		query.append("                  FROM CIM_OPTM_STK_SMRY" ).append("\n"); 
		query.append("                 WHERE OPTM_STK_MNG_TP_CD = 'F'" ).append("\n"); 
		query.append("                   AND DMG_FLG = 'A') TGT_YRWK" ).append("\n"); 
		query.append("       FROM  DUAL ) TMP" ).append("\n"); 
		query.append("ON (  OPS.OPTM_STK_MNG_TP_CD = TMP.OPTM_STK_MNG_TP_CD" ).append("\n"); 
		query.append("  AND OPS.DMG_FLG = TMP.DMG_FLG" ).append("\n"); 
		query.append("  AND OPS.CNTR_TPSZ_CD = TMP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  AND OPS.ECC_CD = TMP.ECC_CD" ).append("\n"); 
		query.append("  AND OPS.TGT_YRWK = TMP.TGT_YRWK" ).append("\n"); 
		query.append(") WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET OPS.CNTR_QTY   = TMP.CNTR_QTY" ).append("\n"); 
		query.append("        ,OPS.UPD_USR_ID = TMP.UPD_USR_ID" ).append("\n"); 
		query.append("        ,OPS.UPD_DT	  = SYSDATE" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("  (OPS.OPTM_STK_MNG_TP_CD" ).append("\n"); 
		query.append("  ,OPS.TGT_YRWK" ).append("\n"); 
		query.append("  ,OPS.TGT_MVMT_DT" ).append("\n"); 
		query.append("  ,OPS.ECC_CD" ).append("\n"); 
		query.append("  ,OPS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  ,OPS.MVMT_STS_CD" ).append("\n"); 
		query.append("  ,OPS.DMG_FLG" ).append("\n"); 
		query.append("  ,OPS.CNTR_QTY" ).append("\n"); 
		query.append("  ,OPS.TGT_BSE_DT" ).append("\n"); 
		query.append("  ,OPS.CRE_USR_ID" ).append("\n"); 
		query.append("  ,OPS.CRE_DT" ).append("\n"); 
		query.append("  ,OPS.UPD_USR_ID" ).append("\n"); 
		query.append("  ,OPS.UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("  (TMP.OPTM_STK_MNG_TP_CD" ).append("\n"); 
		query.append("  ,TMP.TGT_YRWK" ).append("\n"); 
		query.append("  ,TMP.TGT_MVMT_DT" ).append("\n"); 
		query.append("  ,TMP.ECC_CD" ).append("\n"); 
		query.append("  ,TMP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  ,TMP.MVMT_STS_CD" ).append("\n"); 
		query.append("  ,TMP.DMG_FLG" ).append("\n"); 
		query.append("  ,TMP.CNTR_QTY" ).append("\n"); 
		query.append("  ,TMP.TGT_BSE_DT" ).append("\n"); 
		query.append("  ,TMP.UPD_USR_ID" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,TMP.UPD_USR_ID" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}