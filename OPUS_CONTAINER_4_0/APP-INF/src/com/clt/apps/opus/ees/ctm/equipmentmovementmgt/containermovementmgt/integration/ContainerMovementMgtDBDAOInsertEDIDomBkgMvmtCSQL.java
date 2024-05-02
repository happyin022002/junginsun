/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDIDomBkgMvmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOInsertEDIDomBkgMvmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배치 실행시 저장
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDIDomBkgMvmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cud_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("st_turn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDIDomBkgMvmtCSQL").append("\n"); 
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
		query.append("INSERT INTO DOM_BOOKING" ).append("\n"); 
		query.append("			(DMST_BKG_NO			," ).append("\n"); 
		query.append("			DEST_RAIL_LOC_CD		," ).append("\n"); 
		query.append("			ST_TURN_FLG				," ).append("\n"); 
		query.append("			CNTR_NO					," ).append("\n"); 
		query.append("			DAT_MNPL_CD				," ).append("\n"); 
		query.append("			DMST_CMDT_CD 	" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     VALUES " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("			@[dmst_bkg_no]			," ).append("\n"); 
		query.append("			NVL((SELECT LOC_CD FROM MDM_LOCATION WHERE UN_LOC_CD = @[dest_loc_cd] AND ROWNUM=1), '')," ).append("\n"); 
		query.append("			NVL(@[st_turn_flg],'N')	," ).append("\n"); 
		query.append("			NVL(@[cntr_no],'')		," ).append("\n"); 
		query.append("			NVL(@[cud_flg],'')		," ).append("\n"); 
		query.append("			' '		" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}