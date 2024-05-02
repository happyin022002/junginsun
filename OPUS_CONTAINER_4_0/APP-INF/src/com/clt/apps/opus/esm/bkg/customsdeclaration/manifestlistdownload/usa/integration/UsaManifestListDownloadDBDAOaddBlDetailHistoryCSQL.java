/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOaddBlDetailHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.25 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Subin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOaddBlDetailHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBlDetailHistory
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOaddBlDetailHistoryCSQL(){
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("his_itm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("pre_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_CSTMS_IBD_HIS_DTL (" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	HIS_SEQ" ).append("\n"); 
		query.append(",	HIS_SUB_SEQ" ).append("\n"); 
		query.append(",	HIS_ITM_CTNT" ).append("\n"); 
		query.append(",	PRE_CTNT" ).append("\n"); 
		query.append(",	CRNT_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[cnt_cd]" ).append("\n"); 
		query.append(",	@[bl_no]" ).append("\n"); 
		query.append(",	@[his_seq]" ).append("\n"); 
		query.append(",	NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_IBD_HIS_DTL) */" ).append("\n"); 
		query.append("HIS_SUB_SEQ" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_IBD_HIS_DTL A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	HIS_SEQ = @[his_seq]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("),0)+1" ).append("\n"); 
		query.append(",	@[his_itm_ctnt]" ).append("\n"); 
		query.append(",	@[pre_ctnt]" ).append("\n"); 
		query.append(",	@[crnt_ctnt]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOaddBlDetailHistoryCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}