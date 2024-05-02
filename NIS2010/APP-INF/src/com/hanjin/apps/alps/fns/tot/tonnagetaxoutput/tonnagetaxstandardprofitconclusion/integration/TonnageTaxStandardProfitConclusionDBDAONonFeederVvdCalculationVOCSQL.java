/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAONonFeederVvdCalculationVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAONonFeederVvdCalculationVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.01.27 이준범 [CHM-201113807-01]
	  * 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
	  * 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
	  *          2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
	  *            변경사항 확인할 수 있게 처리
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAONonFeederVvdCalculationVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAONonFeederVvdCalculationVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TOT_VVD_STL_AMT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("STL_YRMON" ).append("\n"); 
		query.append(",TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",LDB_CAPA_QTY" ).append("\n"); 
		query.append(",BSA_CAPA" ).append("\n"); 
		query.append(",ACT_BSA_CAPA" ).append("\n"); 
		query.append(",VSL_DZND_CAPA" ).append("\n"); 
		query.append(",CHTR_BSA_CAPA" ).append("\n"); 
		query.append(",USG_RT" ).append("\n"); 
		query.append(",FM_VVD_STL_DT" ).append("\n"); 
		query.append(",TO_VVD_STL_DT" ).append("\n"); 
		query.append(",NRT_WGT" ).append("\n"); 
		query.append(",PER_TON_REV" ).append("\n"); 
		query.append(",TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",VOY_DYS" ).append("\n"); 
		query.append(",TONG_TAX_AMT" ).append("\n"); 
		query.append(",NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.STL_YRMON" ).append("\n"); 
		query.append(",NVL((SELECT /*+INDEX_DESC(X XPKTOT_VVD_STL_AMT)*/ X.TONG_STL_BAT_JB_SEQ  FROM TOT_VVD_STL_AMT X WHERE STL_YRMON = @[stl_yrmon]AND ROWNUM =1),1)" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",MAX(A.LDB_CAPA_QTY)" ).append("\n"); 
		query.append(",MAX(A.BSA_CAPA)" ).append("\n"); 
		query.append(",SUM(A.ACT_BSA_CAPA)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",MAX(A.CHTR_BSA_CAPA)" ).append("\n"); 
		query.append(",MAX(A.USG_RT)" ).append("\n"); 
		query.append(",TO_DATE(DECODE(MAX(A.TRD_CD),'ZZZ',@[stl_yrmon]||'01','YYY',@[stl_yrmon]||'01',TO_CHAR(MIN(A.ETD_DT),'YYYYMMDD')), 'YYYYMMDD')" ).append("\n"); 
		query.append(",TO_DATE(DECODE(MAX(A.TRD_CD),'ZZZ',TO_CHAR(TO_DATE(@[stl_yrmon]||'01','YYYYMMDD')+SUM(A.VOY_DYS)+1,'YYYYMMDD'),'YYY',TO_CHAR(TO_DATE(@[stl_yrmon]||'01','YYYYMMDD')+SUM(A.VOY_DYS)+1,'YYYYMMDD'),TO_CHAR(MAX(A.ETD_DT),'YYYYMMDD')), 'YYYYMMDD')" ).append("\n"); 
		query.append(",MAX(A.NRT_WGT)" ).append("\n"); 
		query.append(",MAX(A.PER_TON_REV)" ).append("\n"); 
		query.append(",( SELECT MAX(TONG_FLET_TP_CD) FROM TOT_VESSEL WHERE STL_YR = @[stl_yrmon]AND VSL_CD = A.VSL_CD AND TONG_FLET_TP_CD NOT IN ('L','E'))" ).append("\n"); 
		query.append(",SUM(A.VOY_DYS)" ).append("\n"); 
		query.append(",SUM(TRUNC(A.TONG_TAX_AMT,0))" ).append("\n"); 
		query.append(",0 NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT A" ).append("\n"); 
		query.append("WHERE A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON= @[stl_yrmon])" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("GROUP BY A.STL_YRMON, A.VSL_CD" ).append("\n"); 

	}
}