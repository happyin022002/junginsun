/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.05.18 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge History에 사용될 Sequence 조회
	  * </pre>
	  */
	public AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_AGMT_RAIL_SCG_RT_HIS_SEQ1.NEXTVAL FROM DUAL" ).append("\n"); 

	}
}