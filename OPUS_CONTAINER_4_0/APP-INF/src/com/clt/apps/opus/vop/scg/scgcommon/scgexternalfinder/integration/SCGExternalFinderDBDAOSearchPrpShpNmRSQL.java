/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchPrpShpNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.12 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchPrpShpNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchPrpShpNmRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT IMDG_UN_NO,IMDG_UN_NO_SEQ, PRP_SHP_NM,IMDG_CLSS_CD," ).append("\n"); 
		query.append("(SELECT B.IMDG_CLSS_CD_DESC" ).append("\n"); 
		query.append("FROM SCG_IMDG_CLSS_CD B WHERE B.IMDG_CLSS_CD=A.IMDG_CLSS_CD) IMDG_CLSS_CD_DESC" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO A" ).append("\n"); 
		query.append("WHERE A.IMDG_UN_NO     = @[imdg_un_no]" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchPrpShpNmRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}