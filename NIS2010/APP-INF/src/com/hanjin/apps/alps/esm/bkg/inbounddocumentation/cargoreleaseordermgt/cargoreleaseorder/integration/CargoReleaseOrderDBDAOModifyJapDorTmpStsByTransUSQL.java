/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOModifyJapDorTmpStsByTransUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.02 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOModifyJapDorTmpStsByTransUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOModifyJapDorTmpStsByTransUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOModifyJapDorTmpStsByTransUSQL").append("\n"); 
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
		query.append("UPDATE BKG_JP_DO_IF B" ).append("\n"); 
		query.append("   SET B.JP_DO_GRP_NO     = @[grp_no]" ).append("\n"); 
		query.append("     , B.JP_DO_SND_STS_CD = 'T'" ).append("\n"); 
		query.append("     , B.UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("     , B.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(" WHERE B.JP_DO_SND_STS_CD = 'R'" ).append("\n"); 
		query.append(" AND   B.BKG_NO IN" ).append("\n"); 
		query.append(" 	( " ).append("\n"); 
		query.append(" 	  SELECT A.BKG_NO" ).append("\n"); 
		query.append("	    FROM ( SELECT ROWNUM NUM, A.BKG_NO" ).append("\n"); 
		query.append("	 	         FROM BKG_JP_DO_IF A" ).append("\n"); 
		query.append("	 	        WHERE JP_DO_SND_STS_CD = 'R' ) A" ).append("\n"); 
		query.append("       WHERE NUM < 11" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}