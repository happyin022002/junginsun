/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchEdiSendRsltVeStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.24 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchEdiSendRsltVeStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSendRslt VE Status
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchEdiSendRsltVeStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchEdiSendRsltVeStsRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL A          " ).append("\n"); 
		query.append("      ,SCE_COP_HDR B" ).append("\n"); 
		query.append("      ,SCE_EDI_SND_RSLT C" ).append("\n"); 
		query.append("WHERE  A.VSL_CD       = @[vsl_cd]  " ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO   = @[skd_voy_no] " ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = @[skd_dir_cd]  " ).append("\n"); 
		query.append("AND    SUBSTR(A.NOD_CD,1,5)    = @[vps_port_cd] " ).append("\n"); 
		query.append("#if (${event_tp_cd} == 'ETA' )" ).append("\n"); 
		query.append("AND    A.STND_EDI_STS_CD IN ('VAD', 'VAT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${event_tp_cd} == 'ETD' )" ).append("\n"); 
		query.append("AND    A.STND_EDI_STS_CD IN ('VDL', 'VDT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(A.CLPT_IND_SEQ,'1') = NVL(@[clpt_ind_seq],'1')" ).append("\n"); 
		query.append("AND    B.COP_NO       = A.COP_NO" ).append("\n"); 
		query.append("AND    B.COP_STS_CD   IN ('C','T')" ).append("\n"); 
		query.append("AND    B.CNTR_NO      <> 'COMU0000000'" ).append("\n"); 
		query.append("AND    B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND    C.EDI_STS_CD = 'VE'" ).append("\n"); 
		query.append("AND    C.EDI_SND_TP_CD = 'Y'" ).append("\n"); 

	}
}