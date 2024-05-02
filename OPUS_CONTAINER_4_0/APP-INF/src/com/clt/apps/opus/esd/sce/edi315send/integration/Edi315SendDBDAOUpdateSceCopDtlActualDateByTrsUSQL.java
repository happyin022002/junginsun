/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOUpdateSceCopDtlActualDateByTrsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOUpdateSceCopDtlActualDateByTrsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOUpdateSceCopDtlActualDateByTrs
	  * </pre>
	  */
	public Edi315SendDBDAOUpdateSceCopDtlActualDateByTrsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOUpdateSceCopDtlActualDateByTrsUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_DTL T" ).append("\n"); 
		query.append("   SET ACT_DT       = TO_DATE(@[act_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,T.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	  ,T.ACT_RCV_TP_CD = '10' -- CD00141 " ).append("\n"); 
		query.append("      ,T.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE T.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND T.ACT_CD = DECODE(@[bnd_cd], 'I', 'FITZAD', 'O', 'MOTZAD')" ).append("\n"); 

	}
}