/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOAddInetBlPrnAuthCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddInetBlPrnAuthCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 벌룬 OBL DOWNLOAD 호출
	  * </pre>
	  */
	public BLIssuanceDBDAOAddInetBlPrnAuthCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddInetBlPrnAuthCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,INFO_SEQ" ).append("\n"); 
		query.append("	,AUTH_DT" ).append("\n"); 
		query.append("	,AUTH_OFC_CD" ).append("\n"); 
		query.append("	,AUTH_USR_ID" ).append("\n"); 
		query.append("	,INET_BL_SND_VIA_CD" ).append("\n"); 
		query.append("	,PRN_CUST_TP_CD" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("	,(SELECT NVL(MAX(INFO_SEQ)+1,1) FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,@[ofc_cd]" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,'O'" ).append("\n"); 
		query.append("	,'O'" ).append("\n"); 
		query.append("	,@[bl_no]" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("	,@[usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}