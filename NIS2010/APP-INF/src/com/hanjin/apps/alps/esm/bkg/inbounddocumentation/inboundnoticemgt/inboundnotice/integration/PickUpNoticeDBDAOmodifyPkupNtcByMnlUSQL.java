/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOmodifyPkupNtcByMnlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.05.06 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmodifyPkupNtcByMnlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOmodifyPkupNtcByMnlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmodifyPkupNtcByMnlUSQL").append("\n"); 
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
		query.append("UPDATE BKG_PKUP_NTC SET " ).append("\n"); 
		query.append("	MNL_FLG = @[mnl_flg]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	NTC_SEQ = @[ntc_seq]" ).append("\n"); 

	}
}