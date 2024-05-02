/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddJapDorTmpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2010.01.08 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddJapDorTmpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전송될 대상으로 JPCUS_SLOG Table에 Insert 한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddJapDorTmpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlse_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddJapDorTmpCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_JP_DO_IF A" ).append("\n"); 
		query.append("( BKG_NO" ).append("\n"); 
		query.append(", RLSE_SEQ" ).append("\n"); 
		query.append(", DO_IF_SEQ" ).append("\n"); 
		query.append(", EVNT_DT" ).append("\n"); 
		query.append(", JP_DO_SND_STS_CD" ).append("\n"); 
		query.append(", JP_DO_GRP_NO" ).append("\n"); 
		query.append(", EVNT_USR_ID" ).append("\n"); 
		query.append(", EVNT_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[bkg_no]           AS BKG_NO" ).append("\n"); 
		query.append(", @[rlse_seq]         AS RLSE_SEQ" ).append("\n"); 
		query.append(", NVL((SELECT /*+INDEX_DESC(T XPKBKG_JP_DO_IF) */ DO_IF_SEQ" ).append("\n"); 
		query.append("FROM BKG_JP_DO_IF T" ).append("\n"); 
		query.append("WHERE T.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND T.RLSE_SEQ = @[rlse_seq]" ).append("\n"); 
		query.append("AND ROWNUM =1),0)+1 AS DO_IF_SEQ" ).append("\n"); 
		query.append(", SYSDATE             AS EVNT_DT" ).append("\n"); 
		query.append(", 'R'                 AS JP_DO_SND_STS_CD" ).append("\n"); 
		query.append(", '-1'                AS JP_DO_GRP_NO" ).append("\n"); 
		query.append(", @[evnt_usr_id]      AS EVNT_USR_ID" ).append("\n"); 
		query.append(", @[evnt_ofc_cd]      AS EVNT_OFC_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]       AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]       AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}