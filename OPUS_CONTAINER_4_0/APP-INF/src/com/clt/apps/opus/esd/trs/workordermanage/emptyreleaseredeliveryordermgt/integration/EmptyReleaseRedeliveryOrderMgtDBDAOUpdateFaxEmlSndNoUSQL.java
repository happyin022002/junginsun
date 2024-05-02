/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNo
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNoUSQL").append("\n"); 
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
		query.append("UPDATE CIM_CNTR_STK K" ).append("\n"); 
		query.append("   SET K.EML_SND_NO = DECODE(K.STK_ISS_CD, 'E', @[eml_snd_no], K.EML_SND_NO)" ).append("\n"); 
		query.append("      ,K.FAX_SND_NO = DECODE(K.STK_ISS_CD, 'F', @[fax_snd_no], K.FAX_SND_NO)" ).append("\n"); 
		query.append(" where STK_LOC_CD = SUBSTR(@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("   and STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   and STK_GATE_IO_CD = DECODE(@[type], 'RLS', 'O', 'I')" ).append("\n"); 
		query.append("   and SO_OFC_CTY_CD = @[so_ofc_cty_cd]" ).append("\n"); 
		query.append("   and SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("   and TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 

	}
}