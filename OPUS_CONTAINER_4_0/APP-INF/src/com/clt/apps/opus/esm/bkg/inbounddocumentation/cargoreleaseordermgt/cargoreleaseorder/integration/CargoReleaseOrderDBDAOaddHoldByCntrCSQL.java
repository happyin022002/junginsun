/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddHoldByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddHoldByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 단위로 Hold 하기 위한 쿼리
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddHoldByCntrCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddHoldByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IB_CGO_RLSE_HLD_CNTR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("   ,CNTR_NO" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       @[bkg_no]                --  AS BKG_NO" ).append("\n"); 
		query.append("      ,@[cntr_no]               --  AS CNTR_NO" ).append("\n"); 
		query.append("      ,@[cre_usr_id]            --  AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                  --  AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]            --  AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                  --  AS UPD_DT   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}