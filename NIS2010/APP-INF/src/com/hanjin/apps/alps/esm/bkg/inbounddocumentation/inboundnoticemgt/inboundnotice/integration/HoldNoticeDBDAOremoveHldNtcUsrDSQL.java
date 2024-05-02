/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOremoveHldNtcUsrDSQL.java
*@FileTitle : Pickup Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.15 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOremoveHldNtcUsrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hold Notice User 삭제한다
	  * </pre>
	  */
	public HoldNoticeDBDAOremoveHldNtcUsrDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM BKG_HLD_NTC_USR" ).append("\n"); 
		query.append("WHERE	HLD_SEQ = @[hld_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.inboundnoticemgt.inboundnotice.integration ").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOremoveHldNtcUsrDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}