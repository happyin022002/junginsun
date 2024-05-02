/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByPortVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.27
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2012.01.27 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE-JUN-BUM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByPortVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정된 VSL Loadable CAPA에 의해 재계산된 데이터 업데이트(tot_port_stl_amt)
	  * 
	  * 2012.01.27 이준범 [CHM-201113807-01]
	  * 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
	  * 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
	  *          2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
	  *            변경사항 확인할 수 있게 처리
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByPortVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nrt_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByPortVOUSQL").append("\n"); 
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
		query.append("UPDATE TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("   SET NRT_WGT     = @[nrt_wgt]" ).append("\n"); 
		query.append("      ,PER_TON_REV = CASE WHEN @[nrt_wgt] > 1000 THEN" ).append("\n"); 
		query.append("                          CASE WHEN (@[nrt_wgt]-1000) > 9000 THEN" ).append("\n"); 
		query.append("                               CASE WHEN (@[nrt_wgt]-10000) > 15000 THEN" ).append("\n"); 
		query.append("                                         ((@[nrt_wgt]-25000)*4)+(15000*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                         ((@[nrt_wgt]-10000)*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                               ELSE" ).append("\n"); 
		query.append("                                    ((@[nrt_wgt]-1000)*11)+(1000*14)" ).append("\n"); 
		query.append("                                END " ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                               @[nrt_wgt]*14    " ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("      ,TONG_TAX_AMT = CASE WHEN BSA_CAPA > ACT_BSA_CAPA THEN " ).append("\n"); 
		query.append("                                NVL((CASE WHEN @[nrt_wgt] > 1000 THEN" ).append("\n"); 
		query.append("                                          CASE WHEN (@[nrt_wgt]-1000) > 9000 THEN" ).append("\n"); 
		query.append("                                               CASE WHEN (@[nrt_wgt]-10000) > 15000 THEN" ).append("\n"); 
		query.append("                                                         ((@[nrt_wgt]-25000)*4)+(15000*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                                    ELSE" ).append("\n"); 
		query.append("                                                         ((@[nrt_wgt]-10000)*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                                     END" ).append("\n"); 
		query.append("                                               ELSE" ).append("\n"); 
		query.append("                                                    ((@[nrt_wgt]-1000)*11)+(1000*14)" ).append("\n"); 
		query.append("                                                END " ).append("\n"); 
		query.append("                                          ELSE" ).append("\n"); 
		query.append("                                               @[nrt_wgt]*14    " ).append("\n"); 
		query.append("                                           END" ).append("\n"); 
		query.append("                                    )*VOY_DYS*(ROUND(NVL(BSA_CAPA/DECODE(LDB_CAPA_QTY,0,null,LDB_CAPA_QTY),0) *100,2)/100),0)" ).append("\n"); 
		query.append("                            ELSE " ).append("\n"); 
		query.append("                                 NVL((CASE WHEN @[nrt_wgt] > 1000 THEN" ).append("\n"); 
		query.append("                                          CASE WHEN (@[nrt_wgt]-1000) > 9000 THEN" ).append("\n"); 
		query.append("                                               CASE WHEN (@[nrt_wgt]-10000) > 15000 THEN" ).append("\n"); 
		query.append("                                                         ((@[nrt_wgt]-25000)*4)+(15000*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                                    ELSE" ).append("\n"); 
		query.append("                                                         ((@[nrt_wgt]-10000)*7)+(9000*11)+(1000*14)" ).append("\n"); 
		query.append("                                                     END" ).append("\n"); 
		query.append("                                               ELSE" ).append("\n"); 
		query.append("                                                    ((@[nrt_wgt]-1000)*11)+(1000*14)" ).append("\n"); 
		query.append("                                                END " ).append("\n"); 
		query.append("                                          ELSE" ).append("\n"); 
		query.append("                                               @[nrt_wgt]*14    " ).append("\n"); 
		query.append("                                           END" ).append("\n"); 
		query.append("                                    )*VOY_DYS*(ROUND(NVL((ACT_BSA_CAPA+ CHTR_BSA_CAPA)/DECODE(LDB_CAPA_QTY,0,NULL,LDB_CAPA_QTY),0)*100,2)/100),0)" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("      ,UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("      ,UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE STL_YRMON LIKE SUBSTR(@[stl_yrmon],1,4)||'%'" ).append("\n"); 
		query.append("   AND VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}