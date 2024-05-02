/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOremovePkupNtcHrByCopyDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOremovePkupNtcHrByCopyDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOremovePkupNtcHrByCopyDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOremovePkupNtcHrByCopyDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_PKUP_NTC_HR" ).append("\n"); 
		query.append("WHERE	PKUP_NTC_SEQ = (SELECT PKUP_NTC_SEQ" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP" ).append("\n"); 
		query.append("WHERE  PKUP_NTC_SND_TP_CD = 'A'" ).append("\n"); 
		query.append("AND    OFC_CD             = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DEL_CD             = DECODE(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd]))" ).append("\n"); 

	}
}