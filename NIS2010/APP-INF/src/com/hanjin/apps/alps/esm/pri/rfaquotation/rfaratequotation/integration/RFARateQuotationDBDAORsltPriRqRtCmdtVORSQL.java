/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriRqRtCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.31 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriRqRtCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriRqRtCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriRqRtCmdtVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  A.QTTN_NO" ).append("\n"); 
		query.append(",  A.QTTN_VER_NO" ).append("\n"); 
		query.append(",  A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",  A.CMDT_SEQ" ).append("\n"); 
		query.append(",  A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",  A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",  A.SRC_INFO_CD" ).append("\n"); 
		query.append(",  A.CRE_USR_ID" ).append("\n"); 
		query.append(",  A.CRE_DT" ).append("\n"); 
		query.append(",  A.UPD_USR_ID" ).append("\n"); 
		query.append(",  A.UPD_DT" ).append("\n"); 
		query.append(",  NVL(@[fic_rt_tp_cd], 'G') FIC_RT_TP_CD" ).append("\n"); 
		query.append(",  DECODE(A.PRC_CMDT_TP_CD," ).append("\n"); 
		query.append("          'G',                                            " ).append("\n"); 
		query.append("          (SELECT PRC_GRP_CMDT_DESC                       --GROUP COMMODITY" ).append("\n"); 
		query.append("             FROM PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("            WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("              AND   QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("              AND   PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("              AND   ROWNUM = 1)," ).append("\n"); 
		query.append("          'R'," ).append("\n"); 
		query.append("          (SELECT REP_CMDT_NM                             --REP COMMODITY" ).append("\n"); 
		query.append("             FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("            WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1)," ).append("\n"); 
		query.append("          'C'," ).append("\n"); 
		query.append("          (SELECT CMDT_NM                                  --COMMODITY" ).append("\n"); 
		query.append("             FROM MDM_COMMODITY" ).append("\n"); 
		query.append("            WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_CMDT A, PRI_RQ_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE  A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND    A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND    A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND    A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("AND    A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND    NVL(B.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("ORDER BY DECODE(A.PRC_CMDT_TP_CD, 'G','1','R','2','C','3'),  A.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}