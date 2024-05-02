/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiIbShRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiIbShRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiIbShRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiIbShRefRSQL").append("\n"); 
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
		query.append("SELECT 'IB_SH_REF_NO:' || SHPR_REF_NO || CHR (10) ||" ).append("\n"); 
		query.append("       'IB_SC_NO:' || CTRT_NO || CHR (10)" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE  XTER_RQST_NO = @[ib_no]" ).append("\n"); 
		query.append("AND    XTER_RQST_SEQ = @[ib_seq]" ).append("\n"); 
		query.append("AND    XTER_SNDR_ID = @[edi_receive_id]" ).append("\n"); 
		query.append("AND    @[group_edi_id] != 'COM02386'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'IB_SH_REF_NO:' || (SELECT XTER_RQST_NO " ).append("\n"); 
		query.append("                             FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append("                            WHERE XTER_RQST_NO = @[ib_no]" ).append("\n"); 
		query.append("                              AND XTER_RQST_SEQ = @[ib_seq]" ).append("\n"); 
		query.append("                              AND XTER_SNDR_ID = @[edi_receive_id]) || CHR (10) ||" ).append("\n"); 
		query.append("       'IB_SC_NO:' || NVL(SC_NO,RFA_NO) || CHR (10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("  AND @[group_edi_id] = 'COM02386'" ).append("\n"); 
		query.append("  --USSA : TRADIANT" ).append("\n"); 

	}
}