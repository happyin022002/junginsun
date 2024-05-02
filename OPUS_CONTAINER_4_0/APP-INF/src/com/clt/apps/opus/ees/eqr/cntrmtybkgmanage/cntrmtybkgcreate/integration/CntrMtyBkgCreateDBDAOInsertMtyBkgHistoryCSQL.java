/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOInsertMtyBkgHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOInsertMtyBkgHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY BKG HISTORY 입력 (EQR_CTRL_MTY_BKG_HIS)
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOInsertMtyBkgHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOInsertMtyBkgHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_MTY_BKG_HIS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     MTY_BKG_NO" ).append("\n"); 
		query.append("    ,HIS_SEQ" ).append("\n"); 
		query.append("    ,HIS_CATE_NM" ).append("\n"); 
		query.append("    ,CRNT_CTNT" ).append("\n"); 
		query.append("    ,MTY_BKG_EVNT_DT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	 @[mty_bkg_no]" ).append("\n"); 
		query.append("	,@[his_seq]" ).append("\n"); 
		query.append("	,@[his_cate_nm]" ).append("\n"); 
		query.append("	,@[crnt_ctnt]" ).append("\n"); 
		query.append("    ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[usr_id]))" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}