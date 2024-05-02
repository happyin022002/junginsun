/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchIgmMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchIgmMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Max Seq.를 조회해 온다.
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchIgmMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_agn_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchIgmMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(MAX(GEN_SEQ), 0) MAX_GEN_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_IDA_TP_RQST_SEQ" ).append("\n"); 
		query.append("WHERE   IDA_SHPR_ID	 =	'S'" ).append("\n"); 
		query.append("AND	    LOCL_AGN_ID	 =	@[ida_agn_id]" ).append("\n"); 
		query.append("AND	    GEN_DT	     =	TO_DATE(@[gen_dt], 'YYMMDD')" ).append("\n"); 

	}
}