/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchBkgInfoByEdoTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.27 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchBkgInfoByEdoTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edo Trans 파일을 검색한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchBkgInfoByEdoTransRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchBkgInfoByEdoTransRSQL").append("\n"); 
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
		query.append("SELECT BK.POL_CD" ).append("\n"); 
		query.append(", BK.POD_CD" ).append("\n"); 
		query.append(", BK.DEL_CD" ).append("\n"); 
		query.append(", BK.BL_NO" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC1.CUST_NM,' ')  ,CHR(13)||CHR(10),' '),1,  35) AS CNEE_NM" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC1.CUST_ADDR,' '),CHR(13)||CHR(10),' '),1,  35) AS CNEE_ADDR1" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC1.CUST_ADDR,' '),CHR(13)||CHR(10),' '),36, 35) AS CNEE_ADDR2" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC1.CUST_ADDR,' '),CHR(13)||CHR(10),' '),70, 35) AS CNEE_ADDR3" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC2.CUST_NM,' ')  ,CHR(13)||CHR(10),' '),1,  35) AS NTFY_NM" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC2.CUST_ADDR,' '),CHR(13)||CHR(10),' '),1,  35) AS NTFY_ADDR1" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC2.CUST_ADDR,' '),CHR(13)||CHR(10),' '),36, 35) AS NTFY_ADDR2" ).append("\n"); 
		query.append(", SUBSTR(REPLACE(NVL(BC2.CUST_ADDR,' '),CHR(13)||CHR(10),' '),70, 35) AS NTFY_ADDR3" ).append("\n"); 
		query.append(", SUBSTR(NVL(REPLACE(DECODE(BK.CUST_TO_ORD_FLG, 'Y', BC2.CUST_NM, BC1.CUST_NM), CHR(13)||CHR(10),' '), ' ') , 1, 35) AS ASPH_NM           -- 실화주명" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC ( BKDO XPKBKG_DO ) */ RCVR_BIZ_NO FROM BKG_DO BKDO WHERE BKDO.BKG_NO = BK.BKG_NO AND ROWNUM = 1 ) AS ASPH_BIZ_NO -- 실화주 사업자번호" ).append("\n"); 
		query.append(", DOC.CSTMS_DESC" ).append("\n"); 
		query.append(", TO_CHAR(DOC.PCK_QTY)  AS PCK_QTY" ).append("\n"); 
		query.append(", DOC.PCK_TP_CD" ).append("\n"); 
		query.append(", TO_CHAR(DOC.ACT_WGT)  AS ACT_WGT" ).append("\n"); 
		query.append(", TO_CHAR(DOC.MEAS_QTY) AS MEAS_QTY" ).append("\n"); 
		query.append(", DECODE((SELECT BKG_NO FROM BKG_EDO_LOG WHERE BKG_NO = BK.BKG_NO AND EDO_RSLT_CD = 'A'),'','O','U') AS BRAC -- BRAC ( 값이 있으면 'U',값이 없으면 'O') 최초 전송인지 재전송인지 구분 (O : Origin(최초),U : Update(재전송))" ).append("\n"); 
		query.append(", (SELECT CMDT.REP_CMDT_NM FROM MDM_REP_CMDT CMDT WHERE CMDT.REP_CMDT_CD = BK.REP_CMDT_CD) AS CMDT_DESC -- CMDT_DESC" ).append("\n"); 
		query.append(", BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VSL_VD" ).append("\n"); 
		query.append(", CNTR.VSL_ENG_NM  AS VSL_NM" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC ( BKDO XPKBKG_DO ) */ SELF_TRNS_FLG FROM BKG_DO BKDO WHERE BKDO.BKG_NO = BK.BKG_NO AND ROWNUM = 1 ) AS SELF_IND" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append(", BKG_VVD      VVD" ).append("\n"); 
		query.append(", MDM_VSL_CNTR CNTR" ).append("\n"); 
		query.append(", BKG_CUSTOMER BC1" ).append("\n"); 
		query.append(", BKG_CUSTOMER BC2" ).append("\n"); 
		query.append(", BKG_BL_DOC   DOC" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO         = BK.BKG_NO" ).append("\n"); 
		query.append("AND VVD.POD_CD         = NVL(BK.PRE_RLY_PORT_CD, BK.POD_CD )" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("AND VVD.VSL_CD         = CNTR.VSL_CD" ).append("\n"); 
		query.append("AND BK.BKG_NO          = BC1.BKG_NO" ).append("\n"); 
		query.append("AND BC1.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND BK.BKG_NO          = BC2.BKG_NO" ).append("\n"); 
		query.append("AND BC2.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("AND BK.BKG_NO          = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO          = @[bkg_no]" ).append("\n"); 

	}
}