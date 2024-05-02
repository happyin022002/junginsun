/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_rq_rt를 일괄 조정한다.
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RQ_RT_SCG_ROUT" ).append("\n"); 
		query.append("    (QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ," ).append("\n"); 
		query.append("    POR_CD, POL_CD, POD_CD, DEL_CD, RCV_TERM_CD, DE_TERM_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ," ).append("\n"); 
		query.append("       C.POR_CD, C.POL_CD, C.POD_CD, C.DEL_CD, C.BKG_RCV_TERM_CD, C.BKG_DE_TERM_CD, @[upd_usr_id], SYSDATE, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("  FROM PRI_RQ_RT A," ).append("\n"); 
		query.append("       PRI_RQ_RT_USD_ROUT_CS B," ).append("\n"); 
		query.append("       PRI_PRS_USD_ROUT_CS_INFO C" ).append("\n"); 
		query.append(" WHERE A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("   AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("   AND A.RT_SEQ = B.RT_SEQ" ).append("\n"); 
		query.append("   AND A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("   AND A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("   AND A.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("   AND B.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("   AND B.ROUT_CS_NO = C.ROUT_CS_NO" ).append("\n"); 
		query.append("   AND B.ROUT_CS_SRC_DT = C.ROUT_CS_SRC_DT" ).append("\n"); 

	}
}