/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOremovePkupMtRtnCyDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.17 
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

public class PickUpNoticeDBDAOremovePkupMtRtnCyDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 
	  * 삭제한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOremovePkupMtRtnCyDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOremovePkupMtRtnCyDSQL").append("\n"); 
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
		query.append("UPDATE BKG_PKUP_CNTR_RTN_YD" ).append("\n"); 
		query.append("SET	 DELT_FLG          = 'Y'" ).append("\n"); 
		query.append("	,DELT_USR_ID       = @[delt_usr_id]" ).append("\n"); 
		query.append("	,DELT_DT           = SYSDATE" ).append("\n"); 
		query.append("	,UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE RTN_YD_SEQ = @[rtn_yd_seq]" ).append("\n"); 
		query.append("AND   DELT_FLG          = 'N'" ).append("\n"); 

	}
}