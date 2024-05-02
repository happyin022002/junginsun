/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOMnrPartnerSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.08.07 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOMnrPartnerSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mnr Partner seq select
	  * </pre>
	  */
	public SppUserManageDBDAOMnrPartnerSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration ").append("\n"); 
		query.append("FileName : SppUserManageDBDAOMnrPartnerSeqRSQL").append("\n"); 
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
		query.append("SELECT MNR_PRNR_CRE_SEQ.NEXTVAL AS SEQ FROM DUAL" ).append("\n"); 

	}
}