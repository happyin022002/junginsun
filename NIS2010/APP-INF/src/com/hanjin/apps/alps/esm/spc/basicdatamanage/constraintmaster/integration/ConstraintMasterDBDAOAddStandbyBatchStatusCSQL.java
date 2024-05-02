/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConstraintMasterDBDAOAddStandbyBatchStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.04 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOAddStandbyBatchStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reprocess 실행시 배치 모니터링을 위한 배치 상태 코드 등록
	  * </pre>
	  */
	public ConstraintMasterDBDAOAddStandbyBatchStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOAddStandbyBatchStatusCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_SB_BAT_MNTR A1 USING" ).append("\n"); 
		query.append("	  (" ).append("\n"); 
		query.append("	  	SELECT BKG_NO" ).append("\n"); 
		query.append("	  	     , ALOC_STS_CD" ).append("\n"); 
		query.append("	  	     , 'R' AS BAT_STS_CD" ).append("\n"); 
		query.append("	  	     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	  	     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	  	  FROM BKG_BOOKING" ).append("\n"); 
		query.append("	  	 WHERE BKG_NO = @[bkg_no]	  " ).append("\n"); 
		query.append("	  ) A2" ).append("\n"); 
		query.append("	  ON (A1.BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("	  WHEN MATCHED THEN" ).append("\n"); 
		query.append("	  	   UPDATE " ).append("\n"); 
		query.append("	  	      SET A1.BAT_STS_CD  = A2.BAT_STS_CD" ).append("\n"); 
		query.append("	  	        , A1.ALOC_STS_CD = A2.ALOC_STS_CD" ).append("\n"); 
		query.append("	  	        , A1.RAPLY_RMK  = SUBSTR('Reprocess:'||SYSDATE ||' <- ' || A1.RAPLY_RMK,1,1000)" ).append("\n"); 
		query.append("	  	        , A1.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("	  	        , A1.UPD_USR_ID  = A2.UPD_USR_ID" ).append("\n"); 
		query.append("	  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	       INSERT (" ).append("\n"); 
		query.append("	       		  A1.BKG_NO" ).append("\n"); 
		query.append("	       		, A1.BAT_STS_CD" ).append("\n"); 
		query.append("	       		, A1.ALOC_STS_CD" ).append("\n"); 
		query.append("	       		, A1.RAPLY_RMK" ).append("\n"); 
		query.append("	       		, A1.CRE_USR_ID" ).append("\n"); 
		query.append("	       		, A1.CRE_DT" ).append("\n"); 
		query.append("	       		, A1.UPD_USR_ID" ).append("\n"); 
		query.append("	       		, A1.UPD_DT" ).append("\n"); 
		query.append("	       	 	       " ).append("\n"); 
		query.append("	       ) VALUES (	       " ).append("\n"); 
		query.append("	       		  A2.BKG_NO" ).append("\n"); 
		query.append("	       		, A2.BAT_STS_CD" ).append("\n"); 
		query.append("	       		, A2.ALOC_STS_CD" ).append("\n"); 
		query.append("	       		, 'Reprocess:'||SYSDATE" ).append("\n"); 
		query.append("	       		, A2.CRE_USR_ID" ).append("\n"); 
		query.append("	       		, SYSDATE" ).append("\n"); 
		query.append("	       		, A2.UPD_USR_ID" ).append("\n"); 
		query.append("	       		, SYSDATE" ).append("\n"); 
		query.append("	       )" ).append("\n"); 

	}
}