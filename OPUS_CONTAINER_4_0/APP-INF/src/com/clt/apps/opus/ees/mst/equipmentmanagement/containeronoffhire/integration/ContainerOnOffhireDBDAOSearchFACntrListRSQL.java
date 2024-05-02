/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchFACntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchFACntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP FA Interface 화면상에서 Type에 따른 Container 정보를 보여준다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchFACntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchFACntrListRSQL").append("\n"); 
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
		query.append("SELECT    ROWNUM AS ROW_SEQ, CNTR_NO, CNTR_TPSZ_CD, LSTM_CD, MFT_DT, ONH_DT, ONH_YD_CD, ONH_FREE_DYS" ).append("\n"); 
		query.append("          , MIN_ONH_DYS, USED_DYS, CNTR_STS_CD, CRNT_YD_CD, CNMV_STS_CD, CNMV_DT" ).append("\n"); 
		query.append("          , AGMT_CTY_CD, AGMT_SEQ, REF_NO           " ).append("\n"); 
		query.append("    FROM  ( " ).append("\n"); 
		query.append("            SELECT   A.CNTR_NO, A.CNTR_TPSZ_CD, C.LSTM_CD" ).append("\n"); 
		query.append("                   , TO_CHAR(A.MFT_DT,'YYYYMMDD') AS MFT_DT" ).append("\n"); 
		query.append("                   , TO_CHAR(A.ONH_DT,'YYYYMMDD') AS ONH_DT" ).append("\n"); 
		query.append("                   , A.ONH_YD_CD, A.ONH_FREE_DYS, A.MIN_ONH_DYS" ).append("\n"); 
		query.append("                   , CASE WHEN C.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                          THEN ROUND(TRUNC(SYSDATE) - A.ONH_DT) + 1" ).append("\n"); 
		query.append("                          ELSE ROUND(TRUNC(SYSDATE) - A.ONH_DT) + 1 END USED_DYS" ).append("\n"); 
		query.append("                   , A.CNMV_STS_CD, A.CRNT_YD_CD, A.CNTR_STS_CD, TO_CHAR(A.CNMV_DT,'YYYYMMDD') AS CNMV_DT  " ).append("\n"); 
		query.append("                   , A.AGMT_CTY_CD, A.AGMT_SEQ, C.REF_NO" ).append("\n"); 
		query.append("              FROM  MST_CONTAINER A," ).append("\n"); 
		query.append("                    LSE_AGREEMENT C            " ).append("\n"); 
		query.append("             WHERE  1=1" ).append("\n"); 
		query.append("               AND  A.AGMT_CTY_CD = C.AGMT_CTY_CD        " ).append("\n"); 
		query.append("               AND  A.AGMT_SEQ    = C.AGMT_SEQ        " ).append("\n"); 
		query.append("               AND  A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            -- CASE : OW Master" ).append("\n"); 
		query.append("            #if (${hid_type} == '0')" ).append("\n"); 
		query.append("               AND A.LOT_PLN_YR||'-'||A.LOT_LOC_CD||'-'||A.CNTR_TPSZ_CD||'-'||TRIM(TO_CHAR(A.LOT_SEQ, '000')) IN (" ).append("\n"); 
		query.append("                   #foreach($key IN ${lot_no})" ).append("\n"); 
		query.append("                       #if($velocityCount < $lot_no.size())" ).append("\n"); 
		query.append("                           '$key'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$key'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			-- CASE : Term Change Master" ).append("\n"); 
		query.append("            #elseif (${hid_type} == '1')" ).append("\n"); 
		query.append("               AND A.TERM_CNG_SEQ IN (" ).append("\n"); 
		query.append("                   #foreach($key IN ${term_cng_seq})" ).append("\n"); 
		query.append("                       #if($velocityCount < $term_cng_seq.size())" ).append("\n"); 
		query.append("                           '$key'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$key'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            -- CASE : Own in Specification Inquiry (Active)" ).append("\n"); 
		query.append("            #elseif (${hid_type} == '2')" ).append("\n"); 
		query.append("               AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("               AND A.LOT_PLN_YR||'-'||A.LOT_LOC_CD||'-'||A.CNTR_TPSZ_CD||'-'||TRIM(TO_CHAR(A.LOT_SEQ, '000')) IN (" ).append("\n"); 
		query.append("                   #foreach($key IN ${lot_no})" ).append("\n"); 
		query.append("                       #if($velocityCount < $lot_no.size())" ).append("\n"); 
		query.append("                           '$key'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$key'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            -- CASE : Lease in Specification Inquiry (Active)" ).append("\n"); 
		query.append("            #elseif (${hid_type} == '3')" ).append("\n"); 
		query.append("              AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("              AND A.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                  ||NVL(TRIM(A.AGMT_CTY_CD||TRIM(TO_CHAR(A.AGMT_SEQ, '000000'))), 'X')" ).append("\n"); 
		query.append("                  ||DECODE(A.LSTM_CD, 'SI', 'X', 'MI', 'X', 'SH', 'X', 'OF', 'X', NVL(TRIM(A.LOT_PLN_YR||'-'||A.LOT_LOC_CD||'-'||A.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(A.LOT_SEQ,'000'))), 'X'))" ).append("\n"); 
		query.append("                  ||NVL(TRIM(TO_CHAR(A.MFTR_VNDR_SEQ, '000000')), 'X')" ).append("\n"); 
		query.append("                   IN (" ).append("\n"); 
		query.append("                   #foreach($key IN ${lot_no})" ).append("\n"); 
		query.append("                       #if($velocityCount < $lot_no.size())" ).append("\n"); 
		query.append("                           '$key'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$key'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    ORDER BY CNTR_NO ASC" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}