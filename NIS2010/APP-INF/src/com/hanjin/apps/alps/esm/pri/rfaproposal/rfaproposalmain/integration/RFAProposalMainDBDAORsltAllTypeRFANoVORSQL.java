/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltAllTypeRFANoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltAllTypeRFANoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltAllTypeRFANoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltAllTypeRFANoVORSQL").append("\n"); 
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
		query.append("-- RFA NO   : M / B / A / C / G" ).append("\n"); 
		query.append("-- RFA TYPE : M / B / S / C / G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||" ).append("\n"); 
		query.append("       CASE WHEN @[rfa_ctrt_tp_cd] = 'B' THEN 'B' " ).append("\n"); 
		query.append("            WHEN @[rfa_ctrt_tp_cd] = 'S' THEN 'A' " ).append("\n"); 
		query.append("            WHEN @[rfa_ctrt_tp_cd] = 'C' THEN 'C' " ).append("\n"); 
		query.append("            WHEN @[rfa_ctrt_tp_cd] = 'M' THEN 'M' " ).append("\n"); 
		query.append("            WHEN @[rfa_ctrt_tp_cd] = 'G' THEN 'G' " ).append("\n"); 
		query.append("            ELSE 'A' END " ).append("\n"); 
		query.append("		||LPAD(NVL(MAX(SUBSTR(RFA_NO,-4)),0)+1,4,'0') RFA_NO " ).append("\n"); 
		query.append("FROM PRI_RP_HDR" ).append("\n"); 
		query.append("WHERE RFA_NO LIKE  SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'%'" ).append("\n"); 

	}
}