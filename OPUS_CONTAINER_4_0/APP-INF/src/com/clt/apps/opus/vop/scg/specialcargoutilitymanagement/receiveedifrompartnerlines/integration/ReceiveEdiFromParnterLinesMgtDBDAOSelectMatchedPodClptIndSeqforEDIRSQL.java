/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPodClptIndSeqforEDIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPodClptIndSeqforEDIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 적합한 pod calling indicator 추출
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPodClptIndSeqforEDIRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPodClptIndSeqforEDIRSQL").append("\n"); 
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
		query.append("SELECT     	NVL(MIN(Y.CLPT_IND_SEQ),-1)" ).append("\n"); 
		query.append("FROM       	VSK_VSL_PORT_SKD       		X" ).append("\n"); 
		query.append("       ,   	VSK_VSL_PORT_SKD       		Y" ).append("\n"); 
		query.append("WHERE      	X.VSL_CD               		= Y.VSL_CD" ).append("\n"); 
		query.append("AND        	X.SKD_VOY_NO           		= Y.SKD_VOY_NO" ).append("\n"); 
		query.append("AND        	X.SKD_DIR_CD           		= Y.SKD_DIR_CD    " ).append("\n"); 
		query.append("AND        	NVL(X.SKD_CNG_STS_CD,'*')  	<> 'S'" ).append("\n"); 
		query.append("AND        	NVL(Y.SKD_CNG_STS_CD,'*')  	<> 'S'" ).append("\n"); 
		query.append("AND    		X.TURN_PORT_IND_CD         	IN ('Y','N')" ).append("\n"); 
		query.append("AND			X.VT_ADD_CALL_FLG			IS NULL" ).append("\n"); 
		query.append("AND        	X.VSL_CD               		= @[vsl_cd]" ).append("\n"); 
		query.append("AND        	X.SKD_VOY_NO           		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND        	X.SKD_DIR_CD           		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND        	X.VPS_PORT_CD          		= @[pol_cd]" ).append("\n"); 
		query.append("AND        	X.CLPT_IND_SEQ         		= @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("AND        	X.CLPT_SEQ             		< Y.CLPT_SEQ" ).append("\n"); 
		query.append("AND        	Y.VPS_PORT_CD          		= @[pod_cd]" ).append("\n"); 

	}
}