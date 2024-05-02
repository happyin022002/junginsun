/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOMGSCgmEqTpSzINVOCSQL.java
*@FileTitle : M.G set Type Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.20 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eui-su Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOMGSCgmEqTpSzINVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOMGSCgmEqTpSzINVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("INSERT INTO  CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("(EQ_TPSZ_CD, DIFF_DESC, EQ_KND_CD)" ).append("\n"); 
		query.append("VALUES(@[eq_tpsz_cd], @[diff_desc], @[eq_knd_cd])" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOMGSCgmEqTpSzINVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}