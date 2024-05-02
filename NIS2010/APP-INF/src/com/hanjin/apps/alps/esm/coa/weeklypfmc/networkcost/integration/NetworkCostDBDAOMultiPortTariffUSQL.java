/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortTariffUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiPortTariffUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History----------------------------------
	  * 2010.05.06 이행지 CHM-201003663-Port tariff vessel class 변경
	  * 2010.05.20 이행지 M:2010-05, W:2010-18  => M:2010-07,W:2010-27 월 부터 VSL_CLSS_CAPA 적용하도록
	  * 2010.09.28 이행지 [CHM-201006114-01] VSL_CLSS_CAPA 적용삭제 
	  * </pre>
	  */
	public NetworkCostDBDAOMultiPortTariffUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_max_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiPortTariffUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PORT_TRF COA" ).append("\n"); 
		query.append("USING (select VSL_CD,SKD_VOY_NO,SKD_DIR_CD,YD_CD,INV_USD_AMT" ).append("\n"); 
		query.append("        from PSO_TGT_VVD_EXPN" ).append("\n"); 
		query.append("       where PSO_BZTP_CD = 7" ).append("\n"); 
		query.append("         and VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("         and skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("         and skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("         and wrk_dt     = substr(@[pso_max_seq],1,8)" ).append("\n"); 
		query.append("         and wrk_seq    = substr(@[pso_max_seq],9)" ).append("\n"); 
		query.append("      ) PSO" ).append("\n"); 
		query.append("ON (COA.VSL_CD = PSO.VSL_CD" ).append("\n"); 
		query.append(" AND COA.SKD_VOY_NO = PSO.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND COA.SKD_DIR_CD = PSO.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND COA.TML_CD     = PSO.YD_CD" ).append("\n"); 
		query.append(" AND COA.SLAN_CD    = @[slan_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("    COA.PORT_USD_AMT = (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN 0" ).append("\n"); 
		query.append("                           ELSE NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("                       END)," ).append("\n"); 
		query.append("    COA.CNL_USD_AMT  = (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("                               ELSE 0" ).append("\n"); 
		query.append("                        END)," ).append("\n"); 
		query.append("    COA.UPD_USR_ID   = @[user_id]," ).append("\n"); 
		query.append("    COA.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (SLAN_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TML_CD,PORT_USD_AMT,CNL_USD_AMT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT) " ).append("\n"); 
		query.append(" VALUES(@[slan_cd],@[vsl_cd],@[skd_voy_no],@[skd_dir_cd],PSO.YD_CD," ).append("\n"); 
		query.append("        (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN 0" ).append("\n"); 
		query.append("              ELSE NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("        END)," ).append("\n"); 
		query.append("        (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("        END)," ).append("\n"); 
		query.append("        @[user_id],sysdate,@[user_id],sysdate                                             " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}