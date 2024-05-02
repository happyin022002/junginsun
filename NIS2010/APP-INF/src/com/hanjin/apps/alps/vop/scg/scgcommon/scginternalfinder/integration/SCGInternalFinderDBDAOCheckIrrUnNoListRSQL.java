/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderDBDAOCheckIrrUnNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.21 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOCheckIrrUnNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irr 에 등록된 unno 인지 확인다.
	  * </pre>
	  */
	public SCGInternalFinderDBDAOCheckIrrUnNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration ").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOCheckIrrUnNoListRSQL").append("\n"); 
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
		query.append("SIU.IMDG_UN_NO" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO SIU" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXISTS(" ).append("\n"); 
		query.append("SELECT 'A'" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append(", SCG_IRR_CNTR SIC" ).append("\n"); 
		query.append("WHERE SIR.VSL_CD = SIC.VSL_CD" ).append("\n"); 
		query.append("AND SIR.SKD_VOY_NO       = SIC.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SIR.SKD_DIR_CD       = SIC.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SIR.SPCL_CGO_IRR_SEQ = SIC.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append("AND SIC.IMDG_UN_NO       = SIU.IMDG_UN_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 

	}
}