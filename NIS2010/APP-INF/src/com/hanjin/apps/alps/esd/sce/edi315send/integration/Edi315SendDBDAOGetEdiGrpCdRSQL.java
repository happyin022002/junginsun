/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi315SendDBDAOGetEdiGrpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2011.03.23 조풍연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author poong yeon cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetEdiGrpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetEdiGrpCd
	  * </pre>
	  */
	public Edi315SendDBDAOGetEdiGrpCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetEdiGrpCdRSQL").append("\n"); 
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
		query.append("select EDI_GRP_CD" ).append("\n"); 
		query.append("From (" ).append("\n"); 
		query.append("    select RNUM, ltrim(sys_connect_by_path(EDI_GRP_CD,',') ,',') EDI_GRP_CD" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT DISTINCT  G.EDI_GRP_CD EDI_GRP_CD, ROW_NUMBER()OVER (  ORDER BY EDI_GRP_CD) RNUM" ).append("\n"); 
		query.append("        FROM    (  " ).append("\n"); 
		query.append("                   SELECT  E.EDI_GRP_CD edi_group_cd, E.CUST_CNT_CD, E.CUST_SEQ, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG  " ).append("\n"); 
		query.append("                   FROM    BKG_CUSTOMER B, EDI_GRP_CUST E  " ).append("\n"); 
		query.append("                   WHERE   B.BKG_NO        =  @[bkg_no]" ).append("\n"); 
		query.append("                       AND B.CUST_CNT_CD    = E.CUST_CNT_CD  " ).append("\n"); 
		query.append("                       AND B.CUST_SEQ       = E.CUST_SEQ" ).append("\n"); 
		query.append("                       AND NVL(E.BKG_CUST_TP_DESC, B.BKG_CUST_TP_CD) LIKE '%'||B.BKG_CUST_TP_CD||'%'" ).append("\n"); 
		query.append("                   UNION  " ).append("\n"); 
		query.append("                   SELECT  E.EDI_GRP_CD edi_group_cd,  E.CUST_CNT_CD, E.CUST_SEQ, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG  " ).append("\n"); 
		query.append("                   FROM    BKG_BOOKING B, EDI_GRP_CUST E  " ).append("\n"); 
		query.append("                   WHERE   B.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("                       AND E.SC_NO         = DECODE(e.bkg_ctrt_div_cd,'1',b.sc_no,'2',b.rfa_no)  " ).append("\n"); 
		query.append("               ) E, EDI_GROUP G  " ).append("\n"); 
		query.append("        WHERE   G.EDI_GRP_CD = E.edi_group_cd  " ).append("\n"); 
		query.append("        AND     G.DELT_FLG <> 'Y'  " ).append("\n"); 
		query.append("        AND     E.CGO_TRC_SVC_FLG <> 'N'  " ).append("\n"); 
		query.append("        AND     E.IB_SVC_FLG <> 'Y'  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        GROUP BY G.EDI_GRP_CD  " ).append("\n"); 
		query.append("        )           " ).append("\n"); 
		query.append("    START WITH RNUM = 1 CONNECT BY PRIOR RNUM = RNUM - 1       " ).append("\n"); 
		query.append("    order by RNUM desc " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

	}
}