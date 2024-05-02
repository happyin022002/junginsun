/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOVskVslPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.07.31 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOVskVslPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOVskVslPortSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOVskVslPortSkdRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(TO_CHAR(DECODE(@[io_bnd_cd], 'O', VPS_ETD_DT, 'A', VPS_ETD_DT, VPS_ETA_DT),'YYYYMMDD'), NULL," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETB_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("TO_CHAR(DECODE(@[io_bnd_cd], 'O', VPS_ETD_DT, 'A', VPS_ETD_DT, VPS_ETA_DT),'YYYYMMDD')) SA_DATE" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("(SELECT DECODE(@[io_bnd_cd], 'O', MAX(CLPT_IND_SEQ), MIN(CLPT_IND_SEQ)) X_CALL_IND" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("AND    VPS_PORT_CD = DECODE(@[io_bnd_cd], 'O', @[pol_cd], 'A', @[pol_cd], @[pod_cd] )) B" ).append("\n"); 
		query.append("WHERE   A.CLPT_IND_SEQ = B.X_CALL_IND" ).append("\n"); 
		query.append("AND		A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    	A.VPS_PORT_CD = DECODE(@[io_bnd_cd], 'O', @[pol_cd], 'A', @[pol_cd], @[pod_cd] )" ).append("\n"); 

	}
}