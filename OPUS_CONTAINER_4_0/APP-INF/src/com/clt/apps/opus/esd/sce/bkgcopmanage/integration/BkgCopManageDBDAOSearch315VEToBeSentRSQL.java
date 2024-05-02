/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearch315VEToBeSentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.30 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearch315VEToBeSentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 COP 의 POD 와 새로 replan 될 PC 의 POD 가 다르거나 arrival date 가 다를 경우 'VE' status 의 VIP315 발송 대상이 되므로
	  * 해당 data 가 존재하는 지 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearch315VEToBeSentRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearch315VEToBeSentRSQL").append("\n"); 
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
		query.append("SELECT E.BKG_NO," ).append("\n"); 
		query.append("E.COP_NO," ).append("\n"); 
		query.append("E.CNTR_NO," ).append("\n"); 
		query.append("E.COP_STS_CD," ).append("\n"); 
		query.append("E.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("E.COP_POD," ).append("\n"); 
		query.append("E.COP_POD_ARR_TIME," ).append("\n"); 
		query.append("E.PC_POD," ).append("\n"); 
		query.append("E.PC_POD_ARR_TIME," ).append("\n"); 
		query.append("E.VSL_CD," ).append("\n"); 
		query.append("E.SKD_VOY_NO," ).append("\n"); 
		query.append("E.SKD_DIR_CD," ).append("\n"); 
		query.append("E.CHK," ).append("\n"); 
		query.append("E.CNT," ).append("\n"); 
		query.append("(CASE WHEN E.CHK = 'Y'" ).append("\n"); 
		query.append("AND E.cnt > 0 THEN 'Y' ELSE 'N' END) SEND_EDI" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.BKG_NO BKG_NO," ).append("\n"); 
		query.append("C.COP_NO COP_NO," ).append("\n"); 
		query.append("C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("COP_STS_CD," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.COP_POD COP_POD," ).append("\n"); 
		query.append("C.COP_POD_ARR_TIME COP_POD_ARR_TIME," ).append("\n"); 
		query.append("B.PC_POD PC_POD," ).append("\n"); 
		query.append("TO_CHAR(B.PC_POD_ARR_TIME, 'yyyymmddhh24miss') PC_POD_ARR_TIME," ).append("\n"); 
		query.append("B.VSL_CD VSL_CD," ).append("\n"); 
		query.append("B.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("B.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("(CASE WHEN (SUBSTR(C.COP_POD, 1, 5) <> SUBSTR(B.PC_POD, 1, 5))" ).append("\n"); 
		query.append("OR (C.COP_POD_ARR_TIME <> B.PC_POD_ARR_TIME) THEN 'Y' ELSE 'N' END) CHK ," ).append("\n"); 
		query.append("D.CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT H.BKG_NO," ).append("\n"); 
		query.append("H.COP_NO," ).append("\n"); 
		query.append("H.CNTR_NO," ).append("\n"); 
		query.append("H.COP_STS_CD," ).append("\n"); 
		query.append("H.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("G.DEST_NOD_CD AS COP_POD," ).append("\n"); 
		query.append("G.DEP_FSH_DT AS COP_POD_ARR_TIME" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("WHERE H.COP_NO IN (" ).append("\n"); 
		query.append("SELECT COP_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C'," ).append("\n"); 
		query.append("'T'," ).append("\n"); 
		query.append("'F')" ).append("\n"); 
		query.append("AND CNTR_NO <> 'COMU0000000')" ).append("\n"); 
		query.append("AND H.PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("AND G.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND G.PCTL_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T') ) C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DEST_NOD_CD PC_POD," ).append("\n"); 
		query.append("DEP_FSH_DT PC_POD_ARR_TIME," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("DECODE(VSL_CD, '', '', SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE PCTL_NO = (" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND PCTL_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T') ) B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COUNT(*) cnt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT E.EDI_GRP_CD edi_group_cd," ).append("\n"); 
		query.append("E.CUST_CNT_CD," ).append("\n"); 
		query.append("E.CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER B," ).append("\n"); 
		query.append("EDI_GRP_CUST E" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND E.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND E.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT E.EDI_GRP_CD edi_group_cd," ).append("\n"); 
		query.append("E.CUST_CNT_CD," ).append("\n"); 
		query.append("E.CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING B," ).append("\n"); 
		query.append("EDI_GRP_CUST E" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND E.SC_NO = case when e.bkg_ctrt_div_cd is null" ).append("\n"); 
		query.append("or e.bkg_ctrt_div_cd = '1' then b.sc_no else b.rfa_no end --2009.08.05 RFA No로도 EDI VIP 315 발송  N200906230046" ).append("\n"); 
		query.append(") E," ).append("\n"); 
		query.append("EDI_GROUP G" ).append("\n"); 
		query.append("WHERE G.EDI_GRP_CD = E.edi_group_cd" ).append("\n"); 
		query.append("AND G.DELT_FLG <> 'Y') D )E" ).append("\n"); 

	}
}