/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOGetImdgCrrRstrSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.19 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOGetImdgCrrRstrSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOGetImdgCrrRstrSeqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT   NVL(MAX( A.IMDG_CRR_RSTR_SEQ ),0)+1 IMDG_CRR_RSTR_SEQ" ).append("\n"); 
		query.append("FROM   SCG_IMDG_CRR_RSTR A" ).append("\n"); 
		query.append("WHERE   A.VSL_OPR_TP_CD = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOGetImdgCrrRstrSeqRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}