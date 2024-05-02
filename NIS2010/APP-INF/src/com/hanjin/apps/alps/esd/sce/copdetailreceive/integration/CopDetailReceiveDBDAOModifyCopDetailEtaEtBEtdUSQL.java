/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopDetailEtaEtBEtdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.29 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopDetailEtaEtBEtdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopDetailEtaEtBEtd
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopDetailEtaEtBEtdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopDetailEtaEtBEtdUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_DTL" ).append("\n"); 
		query.append("SET    ESTM_DT     = TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",ESTM_GDT    = GLOBALDATE_PKG.TIME_CONV_FNC(@[in_vps_port_cd], TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS'), 'GMT')" ).append("\n"); 
		query.append(",UPD_USR_ID  = 'VPS_EST'" ).append("\n"); 
		query.append(",UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE  COP_NO      = CUR_LIST.COP_NO" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ = CUR_LIST.COP_DTL_SEQ" ).append("\n"); 

	}
}