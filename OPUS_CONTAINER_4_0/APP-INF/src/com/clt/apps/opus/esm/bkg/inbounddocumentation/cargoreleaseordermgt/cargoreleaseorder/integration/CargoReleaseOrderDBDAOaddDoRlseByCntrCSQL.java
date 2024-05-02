/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddDoRlseByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddDoRlseByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDoRlseByCntr
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddDoRlseByCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddDoRlseByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DO_CNTR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",RLSE_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",TRKR_NM" ).append("\n"); 
		query.append(",TRKR_PHN_NO" ).append("\n"); 
		query.append(",TRKR_MVMT_REF_NO" ).append("\n"); 
		query.append(",TRKR_MTY_RTN_YD_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[bkg_no]                --  AS BKG_NO" ).append("\n"); 
		query.append(",@[rlse_seq]              --  AS RLSE_SEQ" ).append("\n"); 
		query.append(",@[cntr_no]               --  AS CNTR_NO" ).append("\n"); 
		query.append(",null                     --  AS TRKR_NM" ).append("\n"); 
		query.append(",null                     --  AS TRKR_PHN_NO" ).append("\n"); 
		query.append(",null                     --  AS TRKR_MVMT_REF_NO" ).append("\n"); 
		query.append(",null                     --  AS TRKR_MTY_RTN_YD_CD" ).append("\n"); 
		query.append(",@[cre_usr_id]            --  AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                  --  AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]            --  AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                  --  AS UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}