/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortTariffUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.20 김성욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Sung Wook
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
	  * 2015.01.28 김시몬 [관리회계개선TF] 팬듈럼은 100%로 산출, 운하통과료 100%로 산출
	  * 2015.03.09 김시몬 [관리회계개선TF] CN/IT 국가에 대한 ADD항비 관련 로직 추가
	  * 2015.04.01 김시몬 [관리회계개선TF] PSG LANE 팬듈럼 처리 추가
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
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
		query.append("MERGE INTO MAS_PORT_TRF MAS" ).append("\n"); 
		query.append("USING (select A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.YD_CD, " ).append("\n"); 
		query.append("              CASE WHEN B.TURN_PORT_FLG= 'N' AND B.TURN_PORT_IND_CD = 'N' THEN INV_USD_AMT" ).append("\n"); 
		query.append("                   WHEN B.SLAN_CD IN ('IMU','PM1','PSG','HPM','CPM') THEN INV_USD_AMT" ).append("\n"); 
		query.append("                   WHEN SUBSTR(A.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN INV_USD_AMT" ).append("\n"); 
		query.append("                   ELSE INV_USD_AMT * 0.5" ).append("\n"); 
		query.append("              END INV_USD_AMT," ).append("\n"); 
		query.append("              NVL((" ).append("\n"); 
		query.append("                   SELECT WK_VSL_DTRB_AMT   " ).append("\n"); 
		query.append("                     FROM MAS_PORT_ADD_TRF C" ).append("\n"); 
		query.append("                    WHERE C.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                      AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND C.CNT_CD     = 'CN'" ).append("\n"); 
		query.append("                  ) * RATIO_TO_REPORT(INV_USD_AMT) OVER(PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD),0) AS CHN_PORT_ADD_AMT," ).append("\n"); 
		query.append("              NVL((" ).append("\n"); 
		query.append("                   SELECT WK_VSL_DTRB_AMT" ).append("\n"); 
		query.append("                     FROM MAS_PORT_ADD_TRF C" ).append("\n"); 
		query.append("                    WHERE C.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                      AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND C.CNT_CD     = 'IT'" ).append("\n"); 
		query.append("                  ) * RATIO_TO_REPORT(INV_USD_AMT) OVER(PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD),0) AS ITA_PORT_ADD_AMT              " ).append("\n"); 
		query.append("        from PSO_TGT_VVD_EXPN A," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("       where PSO_BZTP_CD = 7" ).append("\n"); 
		query.append("         and A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("         and A.skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("         and A.skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("         and A.wrk_dt     = substr(@[pso_max_seq],1,8)" ).append("\n"); 
		query.append("         and A.wrk_seq    = substr(@[pso_max_seq],9)" ).append("\n"); 
		query.append("         AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("         AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND A.YD_CD      = B.YD_CD" ).append("\n"); 
		query.append("         AND B.CLPT_SEQ   = (SELECT MIN(CLPT_SEQ) " ).append("\n"); 
		query.append("                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                              WHERE VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND YD_CD      = B.YD_CD" ).append("\n"); 
		query.append("                                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S')" ).append("\n"); 
		query.append("      ) PSO" ).append("\n"); 
		query.append("ON (MAS.VSL_CD = PSO.VSL_CD" ).append("\n"); 
		query.append(" AND MAS.SKD_VOY_NO = PSO.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND MAS.SKD_DIR_CD = PSO.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND MAS.TML_CD     = PSO.YD_CD" ).append("\n"); 
		query.append(" AND MAS.SLAN_CD    = @[slan_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("    MAS.PORT_USD_AMT = (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN 0" ).append("\n"); 
		query.append("                           ELSE NVL(PSO.INV_USD_AMT,0) + DECODE(NVL(MAS.CHN_PORT_ADD_AMT,0),0,NVL(PSO.CHN_PORT_ADD_AMT,0),NVL(MAS.CHN_PORT_ADD_AMT,0)) + DECODE(NVL(MAS.ITA_PORT_ADD_AMT,0),0,NVL(PSO.ITA_PORT_ADD_AMT,0),NVL(MAS.ITA_PORT_ADD_AMT,0))" ).append("\n"); 
		query.append("                       END)," ).append("\n"); 
		query.append("    MAS.CNL_USD_AMT  = (CASE WHEN SUBSTR(PSO.YD_CD,1,5) NOT IN ('EGSUZ','PAPAC') THEN 0" ).append("\n"); 
		query.append("                             ELSE NVL(PSO.INV_USD_AMT,0) + DECODE(NVL(MAS.CHN_PORT_ADD_AMT,0),0,NVL(PSO.CHN_PORT_ADD_AMT,0),NVL(MAS.CHN_PORT_ADD_AMT,0)) + DECODE(NVL(MAS.ITA_PORT_ADD_AMT,0),0,NVL(PSO.ITA_PORT_ADD_AMT,0),NVL(MAS.ITA_PORT_ADD_AMT,0))" ).append("\n"); 
		query.append("                        END)," ).append("\n"); 
		query.append("    MAS.PORT_ORG_AMT     = NVL(PSO.INV_USD_AMT,0)," ).append("\n"); 
		query.append("    MAS.CHN_PORT_ADD_AMT = DECODE(NVL(MAS.CHN_PORT_ADD_AMT,0),0,NVL(PSO.CHN_PORT_ADD_AMT,0),NVL(MAS.CHN_PORT_ADD_AMT,0))," ).append("\n"); 
		query.append("    MAS.ITA_PORT_ADD_AMT = DECODE(NVL(MAS.ITA_PORT_ADD_AMT,0),0,NVL(PSO.ITA_PORT_ADD_AMT,0),NVL(MAS.ITA_PORT_ADD_AMT,0))," ).append("\n"); 
		query.append("    MAS.UPD_USR_ID       = @[user_id]," ).append("\n"); 
		query.append("    MAS.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (SLAN_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TML_CD,PORT_USD_AMT,CNL_USD_AMT,PORT_ORG_AMT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,CHN_PORT_ADD_AMT,ITA_PORT_ADD_AMT) " ).append("\n"); 
		query.append(" VALUES(@[slan_cd],@[vsl_cd],@[skd_voy_no],@[skd_dir_cd],PSO.YD_CD," ).append("\n"); 
		query.append("        (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN 0" ).append("\n"); 
		query.append("              ELSE NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("        END)," ).append("\n"); 
		query.append("        (CASE WHEN SUBSTR(PSO.YD_CD,1,5) IN ('EGSUZ','PAPAC') THEN NVL(PSO.INV_USD_AMT,0)" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("        END)," ).append("\n"); 
		query.append("        NVL(PSO.INV_USD_AMT,0)," ).append("\n"); 
		query.append("        @[user_id],sysdate,@[user_id],sysdate, NVL(PSO.CHN_PORT_ADD_AMT,0),NVL(PSO.ITA_PORT_ADD_AMT,0)                                           " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}