/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMNULUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMNULUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailCurrentStatusByMNUL
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMNULUSQL(){
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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMNULUSQL").append("\n"); 
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
		query.append("UPDATE sce_cop_dtl" ).append("\n"); 
		query.append("SET    act_sts_cd    = 'F'" ).append("\n"); 
		query.append(",act_dt        = to_date(@[act_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",act_rcv_tp_cd = '4'   -- Manual 등록" ).append("\n"); 
		query.append(",upd_usr_id    = @[upd_usr_id]" ).append("\n"); 
		query.append(",upd_dt        = SYSDATE" ).append("\n"); 
		query.append(",act_dat_rcv_dt=GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, SUBSTR(NOD_CD,1,5))" ).append("\n"); 
		query.append("WHERE  act_sts_cd    = 'C'" ).append("\n"); 
		query.append("AND    cop_no        = @[cop_no]" ).append("\n"); 
		query.append("AND    cop_dtl_seq   = @[cop_dtl_seq]" ).append("\n"); 

	}
}