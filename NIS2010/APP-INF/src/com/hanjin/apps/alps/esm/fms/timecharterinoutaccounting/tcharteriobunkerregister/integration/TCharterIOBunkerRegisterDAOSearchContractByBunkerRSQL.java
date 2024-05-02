/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.25
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.25 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL
	  * 2011.05.25 [CHM-201111076-01] 이준범
	  * 제목 : Bunker Data Management 로직 변경 요청
	  * 내용 : Bunker Data Management에서 저장하는 BOD/BOR Data가 Agreement에 미 반영 되도록 로직 변경 
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL").append("\n"); 
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
		query.append("SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("	   EFF_DT," ).append("\n"); 
		query.append("	   EXP_DT," ).append("\n"); 
		query.append("	   ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("       ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("	   ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("	   ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("	   FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("	   DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("	   FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("	   DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("	   SUBSTR(BOD_PORT_CD,INSTR(BOD_PORT_CD,'@')+1,LENGTH(BOD_PORT_CD)) BOD_PORT_CD," ).append("\n"); 
		query.append("	   SUBSTR(BOR_PORT_CD,INSTR(BOR_PORT_CD,'@')+1,LENGTH(BOR_PORT_CD)) BOR_PORT_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT MIN(FLET_CTRT_NO) FLET_CTRT_NO," ).append("\n"); 
		query.append("			   DECODE(MIN(EFF_DT),NULL,NULL,TO_CHAR(MIN(EFF_DT),'YYYYMMDDHH24MI')) EFF_DT," ).append("\n"); 
		query.append("			   DECODE(MIN(EXP_DT),NULL,NULL,TO_CHAR(MIN(EXP_DT),'YYYYMMDDHH24MI')) EXP_DT," ).append("\n"); 
		query.append("			   DECODE(MAX(ACT_FOIL_BOD_QTY),0,NULL,MAX(ACT_FOIL_BOD_QTY)) ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("			   DECODE(MAX(ACT_DOIL_BOD_QTY),0,NULL,MAX(ACT_DOIL_BOD_QTY)) ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("			   DECODE(MAX(ACT_FOIL_BOR_QTY),0,NULL,MAX(ACT_FOIL_BOR_QTY)) ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("			   DECODE(MAX(ACT_DOIL_BOR_QTY),0,NULL,MAX(ACT_DOIL_BOR_QTY)) ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("			   DECODE(MAX(FOIL_BOD_OUT_PRC),0,NULL,ROUND(MAX(FOIL_BOD_OUT_PRC),2)) FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("			   DECODE(MAX(DOIL_BOD_OUT_PRC),0,NULL,ROUND(MAX(DOIL_BOD_OUT_PRC),2)) DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("			   DECODE(MAX(FOIL_BOR_OUT_PRC),0,NULL,ROUND(MAX(FOIL_BOR_OUT_PRC),2)) FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("			   DECODE(MAX(DOIL_BOR_OUT_PRC),0,NULL,ROUND(MAX(DOIL_BOR_OUT_PRC),2)) DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("               MIN(BOD_PORT_CD) BOD_PORT_CD," ).append("\n"); 
		query.append("		       MIN(BOR_PORT_CD) BOR_PORT_CD" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("				   BNK_DT EFF_DT," ).append("\n"); 
		query.append("				   NULL EXP_DT," ).append("\n"); 
		query.append("				   BNK_QTY ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("				   BNK_PRC_AMT FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   BNK_SEQ || '@' || PORT_CD BOD_PORT_CD," ).append("\n"); 
		query.append("				   NULL BOR_PORT_CD," ).append("\n"); 
		query.append("				   ROW_NUMBER() OVER(ORDER BY BNK_DT) RNUM" ).append("\n"); 
		query.append("			  FROM FMS_BUNKER" ).append("\n"); 
		query.append("			 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("			   AND BNK_YRMON = REPLACE(@[bnk_yrmon],'-','')" ).append("\n"); 
		query.append("			   AND BNK_TP_CD = 'BOD'" ).append("\n"); 
		query.append("			   AND (ACCT_CD, ACCT_ITM_SEQ) IN (SELECT MI.ACCT_CD, MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												 FROM FMS_ACCT_CATE MC, FMS_ACCT_ITM MI" ).append("\n"); 
		query.append("												WHERE MC.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("												  AND MC.ACCT_CD = MI.ACCT_CD" ).append("\n"); 
		query.append("												  AND MC.ACCT_ITM_SEQ = MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												  AND MI.ACCT_ITM_SEQ = 33)" ).append("\n"); 
		query.append("			   AND ROWNUM =1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("				   NULL EFF_DT," ).append("\n"); 
		query.append("				   NULL EXP_DT," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("				   BNK_QTY ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   BNK_PRC_AMT DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   BNK_SEQ || '@' || PORT_CD BOD_PORT_CD," ).append("\n"); 
		query.append("				   NULL BOR_PORT_CD," ).append("\n"); 
		query.append("				   ROW_NUMBER() OVER(ORDER BY BNK_DT) RNUM" ).append("\n"); 
		query.append("			  FROM FMS_BUNKER" ).append("\n"); 
		query.append("			 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("			   AND BNK_YRMON = REPLACE(@[bnk_yrmon],'-','')" ).append("\n"); 
		query.append("			   AND BNK_TP_CD = 'BOD'" ).append("\n"); 
		query.append("			   AND (ACCT_CD, ACCT_ITM_SEQ) IN (SELECT MI.ACCT_CD, MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												 FROM FMS_ACCT_CATE MC, FMS_ACCT_ITM MI" ).append("\n"); 
		query.append("												WHERE MC.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("												  AND MC.ACCT_CD = MI.ACCT_CD" ).append("\n"); 
		query.append("												  AND MC.ACCT_ITM_SEQ = MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												  AND MI.ACCT_ITM_SEQ = 34)" ).append("\n"); 
		query.append("			   AND ROWNUM =1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("				   NULL EFF_DT," ).append("\n"); 
		query.append("				   BNK_DT EXP_DT," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("				   BNK_QTY ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   BNK_PRC_AMT FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   NULL BOD_PORT_CD," ).append("\n"); 
		query.append("				   BNK_SEQ || '@' || PORT_CD BOR_PORT_CD," ).append("\n"); 
		query.append("				   ROW_NUMBER() OVER(ORDER BY BNK_DT DESC) RNUM" ).append("\n"); 
		query.append("			  FROM FMS_BUNKER" ).append("\n"); 
		query.append("			 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("			   AND BNK_YRMON = REPLACE(@[bnk_yrmon],'-','')" ).append("\n"); 
		query.append("			   AND BNK_TP_CD = 'BOR'" ).append("\n"); 
		query.append("			   AND (ACCT_CD, ACCT_ITM_SEQ) IN (SELECT MI.ACCT_CD, MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												 FROM FMS_ACCT_CATE MC, FMS_ACCT_ITM MI" ).append("\n"); 
		query.append("												WHERE MC.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("												  AND MC.ACCT_CD = MI.ACCT_CD" ).append("\n"); 
		query.append("												  AND MC.ACCT_ITM_SEQ = MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												  AND MI.ACCT_ITM_SEQ = 33)" ).append("\n"); 
		query.append("			   AND ROWNUM =1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("				   NULL EFF_DT," ).append("\n"); 
		query.append("				   NULL EXP_DT," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("				   0 ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("				   BNK_QTY ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("				   0 FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				   0 FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   BNK_PRC_AMT DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				   NULL BOD_PORT_CD," ).append("\n"); 
		query.append("				   BNK_SEQ || '@' || PORT_CD BOR_PORT_CD," ).append("\n"); 
		query.append("				   ROW_NUMBER() OVER(ORDER BY BNK_DT DESC) RNUM" ).append("\n"); 
		query.append("			  FROM FMS_BUNKER" ).append("\n"); 
		query.append("			 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("			   AND BNK_YRMON = REPLACE(@[bnk_yrmon],'-','')" ).append("\n"); 
		query.append("			   AND BNK_TP_CD = 'BOR'" ).append("\n"); 
		query.append("			   AND (ACCT_CD, ACCT_ITM_SEQ) IN (SELECT MI.ACCT_CD, MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												 FROM FMS_ACCT_CATE MC, FMS_ACCT_ITM MI" ).append("\n"); 
		query.append("												WHERE MC.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("												  AND MC.ACCT_CD = MI.ACCT_CD" ).append("\n"); 
		query.append("												  AND MC.ACCT_ITM_SEQ = MI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												  AND MI.ACCT_ITM_SEQ = 34)" ).append("\n"); 
		query.append("			   AND ROWNUM =1" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("WHERE 1 = 2" ).append("\n"); 

	}
}