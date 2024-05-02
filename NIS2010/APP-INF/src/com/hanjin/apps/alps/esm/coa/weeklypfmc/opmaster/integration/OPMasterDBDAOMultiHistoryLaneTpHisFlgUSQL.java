/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.09 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_LANE_RGST - LANE_TP_HIS_FLG update
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration ").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL").append("\n"); 
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
		query.append("UPDATE COA_LANE_RGST A SET" ).append("\n"); 
		query.append("A.LANE_TP_HIS_FLG" ).append("\n"); 
		query.append("= (SELECT DECODE(COUNT(*),0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM COA_LANE_TP_HIS B" ).append("\n"); 
		query.append("WHERE A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("AND A.IOC_CD   = B.IOC_CD)" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE A.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND A.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND A.IOC_CD   = @[ioc_cd]" ).append("\n"); 

	}
}