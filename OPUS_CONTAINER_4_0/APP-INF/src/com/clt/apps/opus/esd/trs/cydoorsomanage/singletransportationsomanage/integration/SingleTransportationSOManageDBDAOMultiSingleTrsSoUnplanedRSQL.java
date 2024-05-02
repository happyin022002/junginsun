/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.16 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unpland SO일 경우 COP_NO, COST_ACT_GRP_SEQ, FROM NODE, TO NODE, Unmathced 여부를 체 같이
	  * 체크하여 이 정보가 중복될 경우엔 S/O를 발행할 수 없다.
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("('COP No:'||COP_NO||', BKG No:'||BKG_NO||', CNTR No:'||EQ_NO) CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND FM_NOD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append("AND TO_NOD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("AND NVL(UPLN_SO_FLG,'N')     = 'Y'" ).append("\n"); 

	}
}