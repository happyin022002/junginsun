/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgDBDAOSearchRailFuelFixScgAgmtVerifySeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.06.08 박준용
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

public class AgreementRailScgDBDAOSearchRailFuelFixScgAgmtVerifySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Surcharge Verify에 사용할 Sequence 조회
	  * </pre>
	  */
	public AgreementRailScgDBDAOSearchRailFuelFixScgAgmtVerifySeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOSearchRailFuelFixScgAgmtVerifySeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_AGMT_RAIL_SCG_RT_TMP_SEQ1.NEXTVAL FROM DUAL" ).append("\n"); 

	}
}