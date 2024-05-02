/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOSearchGetIdaGstRtoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOSearchGetIdaGstRtoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGetIdaGstRto
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOSearchGetIdaGstRtoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOSearchGetIdaGstRtoRSQL").append("\n"); 
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
		query.append("SELECT   @[ida_sac_cd] AS IDA_SAC_CD" ).append("\n"); 
		query.append("       , IDA_CGST_RTO" ).append("\n"); 
		query.append("       , IDA_SGST_RTO" ).append("\n"); 
		query.append("       , IDA_IGST_RTO" ).append("\n"); 
		query.append("       , IDA_UGST_RTO" ).append("\n"); 
		query.append("FROM     TABLE ( INV_GET_IDA_GST_RTO_FNC ( INV_GET_GST_DIV_CD_FNC ( @[ofc_cd], 'V', NULL, NULL, @[vndr_seq], NULL ), @[ida_sac_cd] ) ) I" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 

	}
}